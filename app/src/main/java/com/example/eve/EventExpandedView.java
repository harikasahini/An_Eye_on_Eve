package com.example.eve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class EventExpandedView extends AppCompatActivity {

    private String eveName;
    private String eveLoc;
    private String eveDesc;
    private String eveDate;
    private String eveTime;
    private String orgName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_expanded_view);


        Intent intent=getIntent();
        this.eveName = intent.getExtras().getString("EventName");
        this.eveLoc = intent.getExtras().getString("EventLoc");
        this.eveDate = intent.getExtras().getString("EveDate");
        this.eveDesc = intent.getExtras().getString("description");
        this.eveTime = intent.getExtras().getString("EveTime");
        this.orgName=intent.getExtras().getString("organization");


        ImageView iv=findViewById(R.id.eveImg);
        int[] images = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.youth,R.drawable.img_4,R.drawable.img_5};
        Random rand = new Random();
        iv.setImageResource(images[rand.nextInt(images.length)]);
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

        TextView eveorgNameTV=findViewById(R.id.eveOrgNameTV);
        eveorgNameTV.setText("Organization : "+orgName);


    }
}