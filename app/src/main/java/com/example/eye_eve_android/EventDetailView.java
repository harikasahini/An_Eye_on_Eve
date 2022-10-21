package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EventDetailView extends AppCompatActivity {

    private String eveName;
    private String eveLoc;
    private String eveDesc;
    private String eveDate;
    private String eveTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail_view);

        Intent intent=getIntent();
        this.eveName = intent.getExtras().getString("EventName");
        this.eveLoc = intent.getExtras().getString("EventLoc");
        this.eveDate = intent.getExtras().getString("EveDate");
        this.eveDesc = intent.getExtras().getString("description");
        this.eveTime = intent.getExtras().getString("EveTime");


        TextView eveNameTV=findViewById(R.id.eveTitleTV);
        eveNameTV.setText(eveName);

        TextView eveLocTV=findViewById(R.id.eveLocTV);
        eveLocTV.setText("Location : "+eveLoc);

        TextView eveDateTV=findViewById(R.id.eveDateTV);
        eveDateTV.setText("Date : "+eveDate);

        TextView eveDescTV=findViewById(R.id.eveDecTV);
        eveDescTV.setText("Description : "+eveDesc);

        TextView eveTimeTV=findViewById(R.id.eveTimeTV);
        eveTimeTV.setText("Time : "+eveTime);


    }
}