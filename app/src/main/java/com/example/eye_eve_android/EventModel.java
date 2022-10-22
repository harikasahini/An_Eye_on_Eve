package com.example.eye_eve_android;

import java.util.ArrayList;
import java.util.Date;

public class EventModel {

    public static class Event {
        public String eventName;
        public String eventLocation;
        public String date;
        public String time;
        public String eventDescription;

        public Event(String eventName, String eventLocation, String date, String time,String eventDescription) {
            this.eventName=eventName;
            this.eventLocation=eventLocation;
            this.date=date;
            this.time=time;
            this.eventDescription=eventDescription;
        }

        public String getEventDescription() {
            return eventDescription;
        }

        public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
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
        Event t1 = new Event("Brick-or-Treat Monster Party!", "Maryville","2022-11-09","12:00 PM", "Join the Monsters as they take over LEGOLAND® Discovery Center Chicago to celebrate the release of their brand-new Halloween 4D Movie, 'The Great Monster Chase!'.");
        eventList.add(t1);
        Event t2 = new Event("Seedfolks", "Kansas city","2022-10-22","1:00 PM","A vacant lot in a broken neighborhood in the middle of the city can become a lot of things. A garbage dump. A gathering spot for trouble.");
        eventList.add(t2);
        Event t3 = new Event("Vintage Garage Brings Vintage to The LOT in Highland Park", "California","2022-10-23","10:00 PM","Savoring the end of outdoor event season, a Vintage Market is coming to the City of Highland Park's alfresco entertainment space The Lot (523 Central) in downtown Highland Park on Sunday.");
        eventList.add(t3);
        Event t4 = new Event("Antique Bottle Show and Sale", "Dallas","2022-12-06","9:00 PM","Dealers across two floors of Macungie Park Hall selling quality antique bottles of all kinds and small table-top antiques. Dairy, breweriana, inks, poisons, stoneware, insulators, soda water, art deco soda, fruit and food jars, much more.");
        eventList.add(t4);
        Event t5 = new Event("Sarasota Water Lantern Festival", "Los Angeles","2022-10-29","9:00 PM","Water Lantern Festival is a floating lantern event that is all about connections. Magical nights in cities across the U.S. include food, games, activities, vendors, music and the beauty of thousands of lanterns adorned with letters of love, hope and dreams reflected upon the water.");
        eventList.add(t5);
    }

}
