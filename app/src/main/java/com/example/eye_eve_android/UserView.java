package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
    }

    public void onClickcard(View v){
        Intent i=new Intent(this,EventDetailView.class);
        startActivity(i);
    }
}