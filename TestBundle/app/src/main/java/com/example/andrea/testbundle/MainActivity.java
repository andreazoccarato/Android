package com.example.andrea.testbundle;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int ACTIVITY_TWO=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivityTwo(View view){
        Intent i=new Intent(MainActivity.this,Activity_two.class);
        startActivityForResult(i,ACTIVITY_TWO);
    }

    public void onActivityResult(int requestcode,int resultCode,Intent data){
        if(requestcode==ACTIVITY_TWO){
            if(resultCode==RESULT_OK){
                Toast.makeText(MainActivity.this,data.getStringExtra("1"), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,data.getStringExtra("2"), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,data.getStringExtra("3"), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,data.getStringExtra("4"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
