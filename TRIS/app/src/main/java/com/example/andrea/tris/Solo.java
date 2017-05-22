package com.example.andrea.tris;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class Solo extends AppCompatActivity {

    Button b;
    int campo[];
    int turno;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo);
        campo=new int[9];
        Arrays.fill(campo,-1);
        turno=0;
    }

    private void mossaPC(){
        Random gen=new Random();
        int p=gen.nextInt(9);
        boolean app=false;
        while(!app){
            if(campo[p]==-1){
                app=true;
                campo[p]=1;
            }
        }
        b= (Button) findViewById(getIdByPos(p));
        b.setText("O");
        b.setEnabled(false);
        turno=0;
    }

    public void mossa(View view){
        int id=view.getId();
        b=(Button)findViewById(id);
        b.setText("X");
        b.setEnabled(false);
        campo[getPos(id)]=0;
        controlloVittoria(view);
        turno=1;
        mossaPC();
        controlloVittoria(view);

    }

    private void controlloVittoria(final View view){
        boolean vittoria=false;

        if(campo[0]==campo[1]&&campo[1]==campo[2]&&campo[1]!=-1){
            vittoria=true;
        }
        else if(campo[3]==campo[4]&&campo[4]==campo[5]&&campo[4]!=-1){
            vittoria=true;
        }
        else if(campo[6]==campo[7]&&campo[7]==campo[8]&&campo[7]!=-1){
            vittoria=true;
        }
        else if(campo[0]==campo[3]&&campo[3]==campo[6]&&campo[3]!=-1){
            vittoria=true;
        }
        else if(campo[1]==campo[4]&&campo[4]==campo[7]&&campo[4]!=-1){
            vittoria=true;
        }
        else if(campo[2]==campo[5]&&campo[5]==campo[8]&&campo[5]!=-1){
            vittoria=true;
        }
        else if(campo[0]==campo[4]&&campo[4]==campo[8]&&campo[4]!=-1){
            vittoria=true;
        }
        else if(campo[2]==campo[4]&&campo[4]==campo[6]&&campo[4]!=-1){
            vittoria=true;
        }

        if(vittoria) {
            text = (TextView) findViewById(R.id.messaggio);
            if (turno == 0) {
                text.setText("HAI VINTO");
            }
            else {
                text.setTextColor(Color.RED);
                text.setText("HAI PERSO");
            }
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    reset(view);
                }
            }, 3000);
        }else{
            int conta=0;
            for (int i=0;i<9;i++){
                if(campo[i]!=-1)conta++;
            }

            if(conta==9){
                text=(TextView)findViewById(R.id.messaggio);
                text.setText("PAREGGIO");
                final Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reset(view);
                    }
                }, 3000);
            }
        }
    }

    private int getPos(int id){
        switch (id){
            case R.id.b1:return 0;
            case R.id.b2:return 1;
            case R.id.b3:return 2;
            case R.id.b4:return 3;
            case R.id.b5:return 4;
            case R.id.b6:return 5;
            case R.id.b7:return 6;
            case R.id.b8:return 7;
            case R.id.b9:return 8;
        }
        return -1;
    }

    private int getIdByPos(int pos){
        switch (pos){
            case 0:return R.id.b1;
            case 1:return R.id.b2;
            case 2:return R.id.b3;
            case 3:return R.id.b4;
            case 4:return R.id.b5;
            case 5:return R.id.b6;
            case 6:return R.id.b7;
            case 7:return R.id.b8;
            case 8:return R.id.b9;
        }
        return pos;
    }

    public void reset(View view){
        Arrays.fill(campo,-1);
        text=(TextView)findViewById(R.id.messaggio);
        text.setText("");
        b=(Button)findViewById(R.id.b1);
        b.setEnabled(true);
        b.setText("");

        b=(Button)findViewById(R.id.b2);
        b.setEnabled(true);
        b.setText("");

        b=(Button)findViewById(R.id.b3);
        b.setEnabled(true);
        b.setText("");

        b=(Button)findViewById(R.id.b4);
        b.setEnabled(true);
        b.setText("");

        b=(Button)findViewById(R.id.b5);
        b.setEnabled(true);
        b.setText("");

        b=(Button)findViewById(R.id.b6);
        b.setEnabled(true);
        b.setText("");

        b=(Button)findViewById(R.id.b7);
        b.setEnabled(true);
        b.setText("");

        b=(Button)findViewById(R.id.b8);
        b.setEnabled(true);
        b.setText("");

        b=(Button)findViewById(R.id.b9);
        b.setEnabled(true);
        b.setText("");


    }

}

