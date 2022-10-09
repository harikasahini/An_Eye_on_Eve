package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSignin(View v){
        Intent i=new Intent(this,UserView.class);
        startActivity(i);
    }

    public void onClickRegister(View v){
        Intent i=new Intent(this,RegistertoApp.class);
        startActivity(i);
    }
}