package com.example.eye_eve_android;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
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
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
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

        //listner attached
        GestureDetectorCompat detector = new GestureDetectorCompat(this, new OrganizerView.RecyclerViewOnGestureListener());
        // add the listener to the recycler
        EventRecycler.addOnItemTouchListener(
                new RecyclerView.SimpleOnItemTouchListener() {
                    @Override
                    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                        return detector.onTouchEvent(e);
                    }
                });

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

    private String eventNamei;
    private String eventLocationi;
    private String eventDesci;
    private String eveDatei;
    private String eveTimei;
    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = EventRecycler.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = EventRecycler.getChildViewHolder(view);
                if (holder instanceof EventAdapter.EventViewHolder) {
                    int position = holder.getAdapterPosition();
                    // handle single tap
                    Log.d("click", "clicked on item "+ position);
                    eventNamei=myModel.eventList.get(position).getEventName();
                    eventLocationi=myModel.eventList.get(position).getEventLocation();
                    eventDesci=myModel.eventList.get(position).getEventDescription();
                    eveDatei=myModel.eventList.get(position).getDate();
                    eveTimei=myModel.eventList.get(position).getTime();
                    onClickcarduv();
                    return true;  // Use up the tap gesture
                }
            }
            // we didn't handle the gesture so pass it on
            return false;
        }}

    public void onClickcarduv(){
        Intent i=new Intent(this,EventDetailView.class);
        i.putExtra("EventName",eventNamei);
        i.putExtra("EventLoc",eventLocationi);
        i.putExtra("EveDate",eveDatei);
        i.putExtra("EveTime",eveTimei);
        i.putExtra("description",eventDesci);
        startActivity(i);
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