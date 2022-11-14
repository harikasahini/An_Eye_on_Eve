package com.example.eve;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EventAdapter extends
        RecyclerView.Adapter<EventAdapter.EventViewHolder>{

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public EventViewHolder(View v) {
            super(v);
        }
    }
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.eventmodellayout, parent, false);
        EventViewHolder eventvh = new EventViewHolder(v);
        return eventvh;
    }

    private EventModel myEventModel;
    private  List<EventModel.Event> arr_test;
    public EventAdapter(EventModel myModel) {
        super();
        this.myEventModel = myModel;
        arr_test=new ArrayList<>(myEventModel.eventList);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        TextView modelTV = holder.itemView.findViewById(R.id.eventNameTV);
        modelTV.setText(myEventModel.eventList.get(position).eventName);
        TextView modelCountTV = holder.itemView.findViewById(R.id.neweventLocationET);
        modelCountTV.setText("Location: "+myEventModel.eventList.get(position).eventLocation);
        TextView taskTimeTV = holder.itemView.findViewById(R.id.eventDateTV);
        taskTimeTV.setText("Date: "+myEventModel.eventList.get(position).date);
        TextView maxclicksTV = holder.itemView.findViewById(R.id.eveTimeTV);
        maxclicksTV.setText("Time: "+myEventModel.eventList.get(position).time);
    }

    @Override
    public int getItemCount() {
        return myEventModel.eventList.size();
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        myEventModel.eventList.clear();
        if (charText.length() == 0) {
            myEventModel.eventList.addAll(arr_test);
        } else {
            for (EventModel.Event eve :  arr_test) {
                if (eve.getEventLocation().toLowerCase(Locale.getDefault()).contains(charText)) {
                    myEventModel.eventList.add(eve);
                }
            }
        }
        notifyDataSetChanged();
    }

}
