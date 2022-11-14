package com.example.eve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class OrganizationAdapter extends
        RecyclerView.Adapter<OrganizationAdapter.OrganizationViewHolder>{

    public static class OrganizationViewHolder extends RecyclerView.ViewHolder {
        public OrganizationViewHolder(View v) {
            super(v);
        }
    }
    @NonNull
    @Override
    public OrganizationAdapter.OrganizationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.organizationslayout, parent, false);
        OrganizationAdapter.OrganizationViewHolder eventvh = new OrganizationAdapter.OrganizationViewHolder(v);
        return eventvh;
    }

    private static EventModel myEventModel;
    private static List<EventModel.Event> arr_test;
    public OrganizationAdapter(EventModel myModel) {
        super();
        this.myEventModel = myModel;
        arr_test=new ArrayList<>(myEventModel.eventList);
    }
    static HashSet<String> orgnoDuplicates=new HashSet<>();
    @Override
    public void onBindViewHolder(@NonNull OrganizationAdapter.OrganizationViewHolder holder, int position) {
        TextView modelTV = holder.itemView.findViewById(R.id.OrganizationsNameTV);
        if(orgnoDuplicates.add(myEventModel.eventList.get(position).organizationName)) {
            modelTV.setText(myEventModel.eventList.get(position).organizationName);
        }
    }

    @Override
    public int getItemCount() {
        return myEventModel.eventList.size();
    }

//    public void filter(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        myEventModel.eventList.clear();
//        if (charText.length() == 0) {
//            myEventModel.eventList.addAll(arr_test);
//        } else {
//            for (EventModel.Event eve :  arr_test) {
//                if (eve.getEventLocation().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    myEventModel.eventList.add(eve);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }

    public void filterOnOrgs(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        myEventModel.eventList.clear();
        if (charText.length() == 0) {
            myEventModel.eventList.addAll(arr_test);
        } else {
            for (EventModel.Event eve :  arr_test) {
                if (eve.getOrgName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    myEventModel.eventList.add(eve);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static void resetListEvents(){
        myEventModel.eventList.clear();
        orgnoDuplicates.clear();
        myEventModel.eventList.addAll(arr_test);
    }


}
