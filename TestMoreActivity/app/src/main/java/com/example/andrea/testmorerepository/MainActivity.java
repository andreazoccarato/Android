package com.example.andrea.testmorerepository;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivityTwo(View view){
        Intent i=new Intent(MainActivity.this,Activity_two.class);
        startActivityForResult(i,2);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent Data){
        if(requestCode==2){
            if(resultCode==RESULT_OK){
                Toast.makeText(this,Data.getStringExtra("isOK"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
