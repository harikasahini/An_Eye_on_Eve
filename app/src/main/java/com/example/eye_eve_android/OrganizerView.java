package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrganizerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_view);
    }

    public void onClickCreate(View v){
        Intent i=new Intent(this,CreateEvent.class);
        startActivity(i);
    }
}