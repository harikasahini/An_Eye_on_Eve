package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class UserView extends AppCompatActivity {
    private EventModel myModel;
    private RecyclerView EventRecycler;
    private EventAdapter EventServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        myModel= EventModel.getSingleton();
        EventServer = new EventAdapter(myModel);
        EventRecycler = findViewById(R.id.tasksRV);
        EventRecycler.setAdapter(EventServer);
        LinearLayoutManager myManager = new LinearLayoutManager(this);
        EventRecycler.setLayoutManager(myManager);
    }
    public void oncreatenewEveUV(String eveName,String eveLoc, String eveDate, String eveTime){
        Log.v("in uv","before notify");
        myModel.eventList.add(new EventModel.Event(eveName,eveLoc,eveDate,eveTime));
        EventServer.notifyItemInserted(myModel.eventList.size()-1);
        Log.v("in ov","after notify");
    }
//    public void onClickcard(View v){
//        Intent i=new Intent(this,EventDetailView.class);
//        startActivity(i);
//    }
}