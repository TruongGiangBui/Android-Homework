package com.example.myapplication;

import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;



public class MainActivity extends AppCompatActivity {
    public Intent intent;
    public static final String EXTRA_MESSAGE = "MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,CaculateActivity.class);
    }
    public void convert(View view){
        if(view.getId()==R.id.CURRENCY) {
            intent.putExtra(EXTRA_MESSAGE, "CURRENCY");
            startActivity(intent);
        }else if(view.getId()==R.id.LENGTH){
            intent.putExtra(EXTRA_MESSAGE, "LENGTH");
            startActivity(intent);
        }else if(view.getId()==R.id.MASS){
            intent.putExtra(EXTRA_MESSAGE, "MASS");
            startActivity(intent);
        }else if(view.getId()==R.id.SPEED){
            intent.putExtra(EXTRA_MESSAGE, "SPEED");
            startActivity(intent);
        }else if(view.getId()==R.id.AREA){
            intent.putExtra(EXTRA_MESSAGE, "AREA");
            startActivity(intent);
        }
    }
}