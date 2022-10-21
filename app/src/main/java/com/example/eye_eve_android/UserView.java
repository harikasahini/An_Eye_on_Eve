package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserView extends AppCompatActivity {
    private EventModel myModel;
    private RecyclerView TaskRecycler;
    private EventAdapter taskServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        myModel= EventModel.getSingleton();
        taskServer = new EventAdapter(myModel);
        TaskRecycler = findViewById(R.id.tasksRV);
        TaskRecycler.setAdapter(taskServer);
        LinearLayoutManager myManager = new LinearLayoutManager(this);
        TaskRecycler.setLayoutManager(myManager);
    }

//    public void onClickcard(View v){
//        Intent i=new Intent(this,EventDetailView.class);
//        startActivity(i);
//    }
}