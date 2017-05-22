package com.example.andrea.tris;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class Game extends AppCompatActivity {

    Button b;
    int campo[];
    int turno;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        campo=new int[9];
        Arrays.fill(campo,-1);
        turno=0;
    }

    public void mossa(View view){
        int id=view.getId();
        b=(Button)findViewById(id);
        if(turno==0){
            b.setText("X");
            b.setEnabled(false);
            campo[getPos(id)]=0;
            controlloVittoria(view);
            turno=1;
        }else{
            b.setText("O");
            b.setEnabled(false);
            campo[getPos(id)]=1;
            controlloVittoria(view);
            turno=0;
        }
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
            if (turno == 0) text.setText("IL GIOCATORE X HA VINTO");
            else text.setText("IL GIOCATORE O HA VINTO");

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
