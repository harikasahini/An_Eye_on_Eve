package com.example.eve;

import java.util.ArrayList;
import java.util.Date;

public class EventModel {

    public static class Event {
        public String eventName;
        public String eventLocation;
        public String date;
        public String time;
        public String eventDescription;
        public String organizationName;

        public Event(String eventName, String eventLocation, String date, String time,String eventDescription,String organizationName) {
            this.eventName=eventName;
            this.eventLocation=eventLocation;
            this.date=date;
            this.time=time;
            this.eventDescription=eventDescription;
            this.organizationName=organizationName;
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

        public String getOrgName() {
            return organizationName;
        }

        public void setOrgName(String orgName) {
            this.organizationName = orgName;
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
        Event t1 = new Event("Brick-or-Treat Monster Party!", "Maryville","2022-11-09","12:00 PM", "Join the Monsters as they take over LEGOLAND® Discovery Center Chicago to celebrate the release of their brand-new Halloween 4D Movie, 'The Great Monster Chase!'.","A follow A");
        eventList.add(t1);
        Event t7 = new Event("Maryville unrocked!", "Art centre,Maryville","2022-12-09","10:00 AM", "The event includes a broad sampling of heavy hors-d'oeuvre from your favorite local Maryville restaurants, a unique tasting of an assortment of wines provided by Green MeadowLiquor, Empire Distributors, RockyTopWineTrail, and Gatlinburg Wine Trail, And Maryville Uncorked wouldn't forget the live music from Cindi Alpert and Robinella!'.","Brodway social group");
        eventList.add(t7);
        Event t2 = new Event("Seedfolks", "Kansas city","2022-10-22","1:00 PM","A vacant lot in a broken neighborhood in the middle of the city can become a lot of things. A garbage dump. A gathering spot for trouble.","Event Rockers");
        eventList.add(t2);

        Event t4 = new Event("Antique Bottle Show and Sale", "Dallas","2022-12-06","9:00 PM","Dealers across two floors of Macungie Park Hall selling quality antique bottles of all kinds and small table-top antiques. Dairy, breweriana, inks, poisons, stoneware, insulators, soda water, art deco soda, fruit and food jars, much more.","Pleasure Services");
        eventList.add(t4);

        Event t5 = new Event("Sarasota Water Lantern Festival", "Los Angeles","2022-10-29","9:00 PM","Water Lantern Festival is a floating lantern event that is all about connections. Magical nights in cities across the U.S. include food, games, activities, vendors, music and the beauty of thousands of lanterns adorned with letters of love, hope and dreams reflected upon the water.","K2k promoters");
        eventList.add(t5);
        Event t6 = new Event("AJR Concert", "Los Angeles","2022-11-12","7:00 PM","Musical night in city which include pop,jazz and more. Please be on time to witness the magic of AJR brothers.","Event Rockers");
        eventList.add(t6);
        Event t3 = new Event("Vintage Garage Brings Vintage to The LOT in Highland Park", "California","2022-10-23","10:00 PM","Savoring the end of outdoor event season, a Vintage Market is coming to the City of Highland Park's alfresco entertainment space The Lot (523 Central) in downtown Highland Park on Sunday.","Give heart");
        eventList.add(t3);
    }

}
