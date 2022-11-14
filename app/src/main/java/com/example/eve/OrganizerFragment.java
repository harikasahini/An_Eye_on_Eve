package com.example.eve;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrganizerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganizerFragment extends Fragment implements SearchView.OnQueryTextListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrganizerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Organizer.
     */
    // TODO: Rename and change types and number of parameters
    public static OrganizerFragment newInstance(String param1, String param2) {
        OrganizerFragment fragment = new OrganizerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        Bundle bundle=getArguments();
        if(bundle!=null){
            eveName=bundle.getString("eveName");
            eveLoc=bundle.getString("eveLocation");
            evetime=bundle.getString("eveDate");
            evedate=bundle.getString("eveTime");
            eveDescp=bundle.getString("eveDesc");
            orgName=bundle.getString("eveOrgName");
            Log.v("evenent",eveName);
            Log.v("eveloc",eveLoc);
            Log.v("evetime",evetime);
            Log.v("evedate",evedate);
            Log.v("evedes",eveDescp);
            flag=1;
        }


    }

    private EventModel myModel;
    private RecyclerView EventRecycler;
    private EventAdapter EventServer;
    private String eventNamei;
    private String eventLocationi;
    private String eventDesci;
    private String eveDatei;
    private String eveTimei;
    private String eveOrgi;
    private String eveName;
    private String eveLoc;
    private String evetime;
    private String evedate;
    private String eveDescp;
    private String orgName;
    private int flag=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_organizer, container, false);
        myModel= EventModel.getSingleton();
        EventServer = new EventAdapter(myModel);
        EventRecycler = view.findViewById(R.id.tasksRV);
        EventRecycler.setAdapter(EventServer);
        LinearLayoutManager myManager = new LinearLayoutManager(view.getContext());
        EventRecycler.setLayoutManager(myManager);
        SearchView editSearch=(SearchView) view.findViewById(R.id.simpleSearchView);
        editSearch.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
        GestureDetectorCompat detector = new GestureDetectorCompat(view.getContext(), new OrganizerFragment.RecyclerViewOnGestureListener());
        // add the listener to the recycler
        EventRecycler.addOnItemTouchListener(
                new RecyclerView.SimpleOnItemTouchListener() {
                    @Override
                    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                        return detector.onTouchEvent(e);
                    }
                });

        if(flag==1){
            myModel.eventList.add(new EventModel.Event(eveName,eveLoc,evedate,evetime,eveDescp,orgName));
            EventServer.notifyItemInserted(myModel.eventList.size()-1);
            flag=0;
        }


        ImageButton purple=(ImageButton) view.findViewById(R.id.imageButton2);
        purple.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //how to go to tasks fragment from here???
                NavdrawerOrganizerActivity.onchy();
            }
        });
        return view;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        EventServer.filter(text);
        return false;
    }

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
                    eveOrgi=myModel.eventList.get(position).getOrgName();
                    onClickcardov();
                    return true;  // Use up the tap gesture
                }
            }
            // we didn't handle the gesture so pass it on
            return false;
        }}
    public void onClickcardov(){
        Intent i=new Intent(getView().getContext(),EventExpandedView.class);
        i.putExtra("EventName",eventNamei);
        i.putExtra("EventLoc",eventLocationi);
        i.putExtra("EveDate",eveDatei);
        i.putExtra("EveTime",eveTimei);
        i.putExtra("description",eventDesci);
        i.putExtra("organization",eveOrgi);
        startActivity(i);
    }


}