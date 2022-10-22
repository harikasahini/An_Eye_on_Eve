package com.example.eye_eve_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class CreateEvent extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_box);
        intent = getIntent();
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);

                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id) {

                    case R.id.nav_home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.nav_organizer:
                        replaceFragment(new ChecklistFragment());
                        break;
                    case R.id.nav_logout:
                        replaceFragment(new LoginFragment());
                        break;
                    case R.id.about:
                        replaceFragment(new Emoji_PeopleFragment());
                        break;
                    default:
                        return true;

                }
                return true;
            }
        });
    }
        private void replaceFragment(Fragment fragment){
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,fragment);
            fragmentTransaction.commit();
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
