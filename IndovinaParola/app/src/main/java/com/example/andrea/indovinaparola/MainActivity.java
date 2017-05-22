package com.example.andrea.indovinaparola;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView text;
    Button ok;
    String parola;
    String maschera;
    int nTentativi;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nTentativi=10;
        parola="";
        maschera="";
        b=new Bundle();
        b.putString("1","telefono");
        b.putString("2","casa");
        b.putString("3","macchina");
        b.putString("4","elefante");
        b.putString("5","computer");
        b.putString("6","libro");
        b.putString("7","scuola");
        b.putString("8","astuccio");
        inizializza();
    }

    private void inizializza(){
        ok= (Button) findViewById(R.id.ok);
        Random gen=new Random();
        parola=b.getString(""+(gen.nextInt(8)+1));
        for (int i=0;i<parola.length();i++){
            if(i==0)maschera+=parola.charAt(0);
            else if(i==parola.length()-1)maschera+=parola.charAt(parola.length()-1);
            else maschera+="_";
        }
        text= (TextView) findViewById(R.id.maschera);
        text.setText(maschera);
    }

    public void check(View view){
        editText= (EditText) findViewById(R.id.risp);
        String risp=editText.getText().toString();
        risp=risp.toLowerCase();
        text= (TextView) findViewById(R.id.messaggio);
        if(risp.equals(parola)){
            text.setTextColor(Color.BLUE);
            text.setText("HAI VINTO");
            Toast.makeText(this,"HAI VINTO", Toast.LENGTH_SHORT).show();
            ok.setEnabled(false);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    reset();
                }
            }, 3000);

        }else{
            text.setTextColor(Color.BLACK);
            nTentativi--;
            if(nTentativi==0){
                text.setTextColor(Color.RED);
                Toast.makeText(this,"HAI PERSO", Toast.LENGTH_SHORT).show();
                text.setText("HAI PERSO");
                ok.setEnabled(false);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reset();
                    }
                }, 3000);

            }else text.setText("Tentativi Rimasti: "+nTentativi);
        }
    }

    private void reset(){
        text= (TextView) findViewById(R.id.messaggio);
        text.setText("");
        nTentativi=10;
        parola="";
        maschera="";
        ok.setEnabled(true);
        inizializza();
    }
}
