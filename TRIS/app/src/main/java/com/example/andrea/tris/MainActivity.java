package com.example.andrea.tris;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;
    boolean single;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        single=true;
    }

    public void solo(View view){
        b=(Button)findViewById(view.getId());
        b.setEnabled(false);
        single=true;
        b.setBackgroundColor(Color.TRANSPARENT);
        b=(Button)findViewById(R.id.multi);
        b.setBackgroundColor(Color.YELLOW);
        b.setEnabled(true);
    }

    public void multi(View view){
        b=(Button)findViewById(view.getId());
        b.setEnabled(false);
        b.setBackgroundColor(Color.TRANSPARENT);
        single=false;
        b=(Button)findViewById(R.id.solo);
        b.setBackgroundColor(Color.YELLOW);
        b.setEnabled(true);
    }

    public void start(View view){
        if(!single){
            Intent i=new Intent(MainActivity.this,Game.class);
            startActivity(i);
        }else{
            Intent i1=new Intent(MainActivity.this,Solo.class);
            startActivity(i1);
        }

    }
}
