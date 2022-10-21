package com.example.eye_eve_android;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class OrganizerView extends AppCompatActivity {

    private EventModel myModel;
    private RecyclerView EventRecycler;
    private EventAdapter EventServer;
    private String eveName;
    private String eveLoc;
    private String evetime;
    private String evedate;
    private String eveDescp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_view);
        myModel= EventModel.getSingleton();
        EventServer = new EventAdapter(myModel);
        EventRecycler = findViewById(R.id.tasksRV);
        EventRecycler.setAdapter(EventServer);
        LinearLayoutManager myManager = new LinearLayoutManager(this);
        EventRecycler.setLayoutManager(myManager);
    }

    public void onClickCreate(View v){
        Intent i=new Intent(this,CreateEvent.class);
        mStartForResult.launch(i);
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        // Handle the Intent
                        eveName=intent.getStringExtra("eveName");
                        eveLoc=intent.getStringExtra("eveLocation");
                        evetime=intent.getStringExtra("eveDate");
                        evedate=intent.getStringExtra("eveTime");
                        eveDescp=intent.getStringExtra("eveDescp");
                        myModel.eventList.add(new EventModel.Event(eveName,eveLoc,evedate,evetime,eveDescp));
                        EventServer.notifyItemInserted(myModel.eventList.size()-1);
                    }
                }
            });

//    public void oncreatenewEveOV(String eveName,String eveLoc, String eveDate, String eveTime){
//        Log.v("in ov","before notify");
//     myModel.eventList.add(new EventModel.Event(eveName,eveLoc,eveDate,eveTime));
//
//        EventServer.notifyItemInserted(myModel.eventList.size()-1);
//        Log.v("in ov","after notify");
//    }

}