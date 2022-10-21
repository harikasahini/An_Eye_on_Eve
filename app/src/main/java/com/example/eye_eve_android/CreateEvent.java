package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateEvent extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        intent = getIntent();
    }

    public void oncreateEvent(View v) {
        EditText newEventName = findViewById(R.id.neweventNameET);
        EditText newOrganizationName = findViewById(R.id.neworganizationNameET);
        EditText newEventDesc = findViewById(R.id.neweventDescriptionET);
        EditText newEventLocation = findViewById(R.id.neweventLocationET);
        EditText newEventDate = findViewById(R.id.neweventDateET);
        EditText newEventTime = findViewById(R.id.neweventTimeET);

        if (newEventName.getText().toString().trim().equalsIgnoreCase("")) {
//            Toast t = Toast.makeText(this, "Event Name is required!", Toast.LENGTH_SHORT);
//             t.show();
            newEventName.setError("Event name is required");
        } else if (newOrganizationName.getText().toString().trim().equalsIgnoreCase("")) {
            newOrganizationName.setError("Organization name is required");
        } else if (newEventDesc.getText().toString().trim().equalsIgnoreCase("")) {
            newEventDesc.setError("Event description is required");
        } else if (newEventLocation.getText().toString().trim().equalsIgnoreCase("")) {
            newEventLocation.setError("Event location is required");
        } else if (newEventDate.getText().toString().trim().equalsIgnoreCase("")) {
            newEventDate.setError("Date on which event happens is required");
        } else if (newEventTime.getText().toString().trim().equalsIgnoreCase("")) {
            newEventTime.setError("Time of event is required");
        } else {
            Toast t = Toast.makeText(this, "Event Created Succesfully!", Toast.LENGTH_SHORT);t.show();
            String eveName = newEventName.getText().toString();
            String eveLocation = newEventLocation.getText().toString();
            String eveDate = newEventDate.getText().toString();
            String eveTime = newEventTime.getText().toString();
            String eveDesc=newEventDesc.getText().toString();
            intent.putExtra("eveName", eveName);
            intent.putExtra("eveLocation", eveLocation);
            intent.putExtra("eveDate", eveDate);
            intent.putExtra("eveTime", eveTime);
            intent.putExtra("eveDescp",eveDesc);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

    }
    }
