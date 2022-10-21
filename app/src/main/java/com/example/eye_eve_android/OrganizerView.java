package com.example.eye_eve_android;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class OrganizerView extends AppCompatActivity {

    private EventModel myModel;
    private RecyclerView EventRecycler;
    private EventAdapter EventServer;
    private String eveName;
    private String eveLoc;
    private String evetime;
    private String evedate;
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
                switch (id)
                {

                    case R.id.nav_home:
                        replaceFragment(new HomeFragment());break;
                    case R.id.nav_CreateAnEvent:
                        replaceFragment(new AddBoxFragment());break;
                    case R.id.nav_organizer:
                        replaceFragment(new ChecklistFragment());break;
                    case R.id.settings:
                        replaceFragment(new SettingsFragment());break;
                    case R.id.nav_logout:
                        replaceFragment(new LoginFragment());break;
                    case R.id.about:
                        replaceFragment(new Emoji_PeopleFragment());break;
                    default:
                        return true;

                }
                return true;
            }
        });
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
                        myModel.eventList.add(new EventModel.Event(eveName,eveLoc,evedate,evetime));
                        EventServer.notifyItemInserted(myModel.eventList.size()-1);
                    }
                }
            });





    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
//    public void oncreatenewEveOV(String eveName,String eveLoc, String eveDate, String eveTime){
//        Log.v("in ov","before notify");
//     myModel.eventList.add(new EventModel.Event(eveName,eveLoc,eveDate,eveTime));
//
//        EventServer.notifyItemInserted(myModel.eventList.size()-1);
//        Log.v("in ov","after notify");
//    }

}