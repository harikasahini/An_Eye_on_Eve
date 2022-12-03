package com.example.eve;

import android.os.Bundle;

import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.eve.ui.gallery.GalleryFragment;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrganizationsUVFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganizationsUVFragment extends Fragment implements SearchView.OnQueryTextListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrganizationsUVFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrganizationsUVFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrganizationsUVFragment newInstance(String param1, String param2) {
        OrganizationsUVFragment fragment = new OrganizationsUVFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private EventModel myModel;
    private RecyclerView EventRecycler;
    private OrganizationAdapter EventServer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_organizations_u_v, container, false);

      //  setupDatamodel();
        SearchView editsearch=(SearchView) view.findViewById(R.id.simpleSearchView);
        editsearch.setOnQueryTextListener((SearchView.OnQueryTextListener) this);

        return view;
    }

//    private void setupDatamodel() {
//        ParseObject newObj = new ParseObject("Events");
//        newObj.put("Event_Name",eventObj.getString("eventName");)
//
//        // Read Parse Objects
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Events");
//
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> results, ParseException e) {
//                for (ParseObject eventObj : results) {
//                    if (e == null) {
//                        String eventID, eventName, eventLocation, Date,Time, eventDescription;
//                        eventID= eventObj.getObjectId();
//                        eventName = eventObj.getString("eventName");
//                        eventLocation = String.valueOf(eventObj.getDate("eventLocation"));
//                        Date=  String.valueOf(eventObj.getDate("Date"));
//                        Time =  eventObj.getString("Time") ;
//                        eventDescription =  eventObj.getString("eventDescription");
//                        Log.v("ObjectID",String.valueOf(eventID));
//
//                        myModel= EventModel.getSingleton();
//
//                        myModel.eventList.add(new EventModel.Event(eventID,eventName,eventLocation, Date, Time,eventDescription));
//
//                        Log.v("Setup EventList Size:", String.valueOf(myModel.eventList.size()));
//                        EventServer = new OrganizationAdapter(myModel);
//
//                        Log.v("adapter", String.valueOf(EventServer.getItemCount()));
//
//                        EventRecycler = EventRecycler.findViewById(R.id.OrganizationsRV);
//                        EventRecycler.setAdapter(EventServer);
//                        LinearLayoutManager myManager = new LinearLayoutManager(getContext());
//                        EventRecycler.setLayoutManager(myManager);
//
//
//                        //listner attached
//                        GestureDetectorCompat detector = new GestureDetectorCompat(getContext(), new OrganizationsUVFragment.RecyclerViewOnGestureListener());
//                        // add the listener to the recycler
//                        EventRecycler.addOnItemTouchListener(
//                                new RecyclerView.SimpleOnItemTouchListener() {
//                                    @Override
//                                    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                                        return detector.onTouchEvent(e);
//                                    }
//                                });
//
//
//                    } else {
//                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//        });
//    }

    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = EventRecycler.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = EventRecycler.getChildViewHolder(view);
                if (holder instanceof OrganizationAdapter.OrganizationViewHolder) {
                    int position = holder.getAdapterPosition();
                    // handle single tap
                    String orgClicked=myModel.eventList.get(position).getOrgName();
                    onClickOrgName(orgClicked);
                    return true;  // Use up the tap gesture
                }
            }
            // we didn't handle the gesture so pass it on
            return false;
        }}
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        EventServer.filterOnOrgs(text);
        return false;
    }

    public void onClickOrgName(String orgSelected){
        EventServer.filterOnOrgs(orgSelected);
        NavdrawerUserActivity.onSelectOrgUV();
    }
}