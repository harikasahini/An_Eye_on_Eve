package com.example.eye_eve_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

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

        //listner attached
        GestureDetectorCompat detector = new GestureDetectorCompat(this,
                new RecyclerViewOnGestureListener());
        // add the listener to the recycler
        EventRecycler.addOnItemTouchListener(
                new RecyclerView.SimpleOnItemTouchListener() {
                    @Override
                    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                        return detector.onTouchEvent(e);
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



//    public void oncreatenewEveUV(String eveName,String eveLoc, String eveDate, String eveTime){
//        Log.v("in uv","before notify");
//        myModel.eventList.add(new EventModel.Event(eveName,eveLoc,eveDate,eveTime));
//        EventServer.notifyItemInserted(myModel.eventList.size()-1);
//        Log.v("in ov","after notify");
//    }
  public void onClickcarduv(){
        Intent i=new Intent(this,EventDetailView.class);
        i.putExtra("EventName",eventNamei);
        i.putExtra("EventLoc",eventLocationi);
        i.putExtra("EveDate",eveDatei);
        i.putExtra("EveTime",eveTimei);
        i.putExtra("description",eventDesci);
        startActivity(i);

    }
}