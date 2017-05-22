package com.example.andrea.testmorerepository;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    public void Return(View view){
        Intent i=new Intent();
        i.putExtra("isOK","Sei tornato alla MainActivity");
        Activity_two.this.setResult(RESULT_OK,i);
        Activity_two.this.finish();
    }
}
