package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistertoApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerto_app);
    }

    public void onClickSigninR(View v){
        Intent i=new Intent(this,OrganizerView.class);
        startActivity(i);
    }

    public void onClickRegisterR(View v){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}