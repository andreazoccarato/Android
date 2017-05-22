package com.example.andrea.testbundle;

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
        Bundle b=new Bundle();
        b.putString("1","ciao");
        b.putString("2","come");
        b.putString("3","stai");
        b.putString("4","?");
        i.putExtras(b);
        Activity_two.this.setResult(RESULT_OK,i);
        Activity_two.this.finish();
    }
}
