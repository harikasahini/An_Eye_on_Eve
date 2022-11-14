package com.example.eve.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eve.EventAdapter;
import com.example.eve.EventExpandedView;
import com.example.eve.EventModel;
import com.example.eve.NavdrawerOrganizerActivity;
import com.example.eve.NavdrawerUserActivity;
import com.example.eve.OrganizationAdapter;
import com.example.eve.R;
import com.example.eve.UserFragment;
import com.example.eve.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment implements SearchView.OnQueryTextListener{

    private EventModel myModel;
    private RecyclerView EventRecycler;
    private OrganizationAdapter EventServer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        myModel= EventModel.getSingleton();
        EventServer = new OrganizationAdapter(myModel);
        EventRecycler = view.findViewById(R.id.OrganizationsRV);
        EventRecycler.setAdapter(EventServer);
        LinearLayoutManager myManager = new LinearLayoutManager(view.getContext());
        EventRecycler.setLayoutManager(myManager);

        SearchView editsearch=(SearchView) view.findViewById(R.id.simpleSearchView);
        editsearch.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
        //listner attached
        GestureDetectorCompat detector = new GestureDetectorCompat(view.getContext(), new GalleryFragment.RecyclerViewOnGestureListener());
        // add the listener to the recycler
        EventRecycler.addOnItemTouchListener(
                new RecyclerView.SimpleOnItemTouchListener() {
                    @Override
                    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                        return detector.onTouchEvent(e);
                    }
                });
        return view;

    }

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
        NavdrawerOrganizerActivity.onSelectOrgOV();
    }
}