package com.example.eye_eve_android;

import java.util.ArrayList;
import java.util.Date;

public class EventModel {

    public static class Event {
        public String eventName;
        public String eventLocation;
        public String date;
        public String time;

        public Event(String eventName, String eventLocation, String date, String time) {
            this.eventName=eventName;
            this.eventLocation=eventLocation;
            this.date=date;
            this.time=time;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getEventLocation() {
            return eventLocation;
        }

        public void setEventLocation(String eventLocation) {
            this.eventLocation = eventLocation;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    private static EventModel theModel = null;
    public static EventModel getSingleton() {
        if (theModel == null) {
            theModel = new EventModel();
        }
        return theModel;
    }
    public ArrayList<Event> eventList;
    private EventModel() {
        eventList = new ArrayList<Event>();
        loadInitialTasks();
    }
    private void loadInitialTasks() {
        Event t1 = new Event("T&T", "Maryville","2022-09-20","12:00 PM");
        eventList.add(t1);
        Event t2 = new Event("A&A", "Jincoki","2022-09-27","1:00 PM");
        eventList.add(t2);
        Event t3 = new Event("Wincoson trailers", "Missouri","2022-09-01","10:00 PM");
        eventList.add(t3);
        Event t4 = new Event("Icognito treats", "Dallas","2022-12-06","9:00 PM");
        eventList.add(t4);
        Event t5 = new Event("Increaser chance of views", "Los Angeles","2022-09-12","9:00 PM");
        eventList.add(t5);
    }

}
