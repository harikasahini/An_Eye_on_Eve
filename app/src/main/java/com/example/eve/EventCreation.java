package com.example.eve;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventCreation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventCreation extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EventCreation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventCreation.
     */
    // TODO: Rename and change types and number of parameters
    public static EventCreation newInstance(String param1, String param2) {
        EventCreation fragment = new EventCreation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        View v= inflater.inflate(R.layout.fragment_event_creation, container, false);

//        Button purple=(Button) v.findViewById(R.id.createEventBTN);
//        purple.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                EditText newEventName =(EditText) v.findViewById(R.id.neweventNameET);
//                EditText newOrganizationName =(EditText) v.findViewById(R.id.neworganizationNameET);
//                EditText newEventDesc =(EditText) v.findViewById(R.id.neweventDescriptionET);
//                EditText newEventLocation =(EditText) v.findViewById(R.id.neweventLocationET);
//                EditText newEventDate =(EditText) v.findViewById(R.id.neweventDateET);
//                EditText newEventTime =(EditText) v.findViewById(R.id.neweventTimeET);
//                if (newEventName.getText().toString().trim().matches("")) {
//            Toast t = Toast.makeText(v.getContext(), "Event Name is required!", Toast.LENGTH_SHORT);
//             t.show();
//                    //newEventName.setError("Event name is required");
//                } else if (newOrganizationName.getText().toString().trim().matches("")) {
//                    newOrganizationName.setError("Organization name is required");
//                } else if (newEventDesc.getText().toString().trim().matches("")) {
//                    newEventDesc.setError("Event description is required");
//                } else if (newEventLocation.getText().toString().trim().matches("")) {
//                    newEventLocation.setError("Event location is required");
//                } else if (newEventDate.getText().toString().trim().matches("")) {
//                    newEventDate.setError("Date on which event happens is required");
//                } else if (newEventTime.getText().toString().trim().matches("")) {
//                    newEventTime.setError("Time of event is required");
//                } else {
//                    String eveName = newEventName.getText().toString();
//                    String eveLocation = newEventLocation.getText().toString();
//                    String eveDate = newEventDate.getText().toString();
//                    String eveTime = newEventTime.getText().toString();
//                    String eveDesc=newEventDesc.getText().toString();
//                Bundle b = new Bundle();
//                    b.putString("eveName",eveName);
//                    b.putString("eveLocation",eveLocation);
//                    b.putString("eveDate", eveDate);
//                    b.putString("eveTime", eveTime);
//                    b.putString("eveDescp",eveDesc);
//                b.putString("HI","Dwithi");
//                    NavdrawerOrganizerActivity.onCreateNewEve(b);
//               }
//
//            }});

        Button createEventClick = v.findViewById(R.id.createEventBTN);
        createEventClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText newEventName=(EditText) v.findViewById(R.id.neweventNameET);
                EditText newOrganizationName=(EditText) v.findViewById(R.id.neworganizationNameET);
                EditText newEventDesc=(EditText) v.findViewById(R.id.neweventDescriptionET);
                EditText newEventLocation=(EditText) v.findViewById(R.id.neweventLocationET);
                EditText newEventDate=(EditText) v.findViewById(R.id.neweventDateET);
                EditText newEventTime=(EditText) v.findViewById(R.id.neweventTimeET);

                if(newEventName.getText().toString().equalsIgnoreCase("")){
                    newEventName.setError("Event name is required!");
                    Toast t = Toast.makeText(v.getContext(), "Event name is required!", Toast.LENGTH_SHORT);
                    t.show();
                }
                else if(newOrganizationName.getText().toString().equalsIgnoreCase("")){
                    newOrganizationName.setError("Organization name is required!");
                    Toast t = Toast.makeText(v.getContext(), "Organization name is required!", Toast.LENGTH_SHORT);
                    t.show();
                }else if(newEventDesc.getText().toString().equalsIgnoreCase("")){
                    newEventDesc.setError("Event description is required!");
                    Toast t = Toast.makeText(v.getContext(), "Event description is required!", Toast.LENGTH_SHORT);
                    t.show();
                }
                else if(newEventLocation.getText().toString().equalsIgnoreCase("")){
                    newEventLocation.setError("Event location is required!");
                    Toast t = Toast.makeText(v.getContext(), "Event location is required!", Toast.LENGTH_SHORT);
                    t.show();
                }
                else if(newEventDate.getText().toString().equalsIgnoreCase("")){
                    newEventDate.setError("Date on which event happens is required!");
                    Toast t = Toast.makeText(v.getContext(), "Date on which event happens is required!", Toast.LENGTH_SHORT);
                    t.show();
                }
                else if(newEventTime.getText().toString().equalsIgnoreCase("")){
                    newEventTime.setError("Time of event is required!");
                    Toast t = Toast.makeText(v.getContext(), "Time of event is required!", Toast.LENGTH_SHORT);
                    t.show();
                }
                else {

                    try {
                        // send back amount*p9rice
                        Bundle b=new Bundle();
                        b.putString("eveName",newEventName.getText().toString());
                        b.putString("eveOrgName",newOrganizationName.getText().toString());
                        b.putString("eveDesc",newEventDesc.getText().toString());
                        b.putString("eveLocation",newEventLocation.getText().toString());
                        b.putString("eveDate",newEventDate.getText().toString());
                        b.putString("eveTime",newEventTime.getText().toString());
                        NavdrawerOrganizerActivity.onCreateNewEve(b);
                    } catch (Exception e) {
                        // Do nothing
                    }
                }
            }
        });

        return v;
    }


}