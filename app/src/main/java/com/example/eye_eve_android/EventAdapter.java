package com.example.eye_eve_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    public EventAdapter(EventModel myModel) {
        super();
        this.myEventModel = myModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        TextView modelTV = holder.itemView.findViewById(R.id.eventNameTV);
        modelTV.setText(myEventModel.eventList.get(position).eventName);
        TextView modelCountTV = holder.itemView.findViewById(R.id.neweventLocationET);
        modelCountTV.setText(String.valueOf(myEventModel.eventList.get(position).eventLocation));
        TextView taskTimeTV = holder.itemView.findViewById(R.id.eventDateTV);
        taskTimeTV.setText(myEventModel.eventList.get(position).date);
        TextView maxclicksTV = holder.itemView.findViewById(R.id.eventTimeTV);
        maxclicksTV.setText(myEventModel.eventList.get(position).time);
    }

    @Override
    public int getItemCount() {
        return myEventModel.eventList.size();

    }


}
