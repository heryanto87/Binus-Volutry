package com.example.id.ac.binus.volutry.model;

import java.io.Serializable;

/*
Edited by: Eric
Date: 09 Feb 2020 11.19 AM
Purpose: implements Serializable to send data to other activity
 */
//simpelnya ini MsImages
public class Event implements Serializable {
    private String EventID;
    private int EventImages;
    private String EventName;
    private String EventDate;
    private String EventCondition;
    private String EventType;
    private String EventDescription;
    private String EventLocation;
    private String EventActivity;
    private String EventDivision;

    public String getEventDivision() {
        return EventDivision;
    }

    public void setEventDivision(String eventDivision) {
        EventDivision = eventDivision;
    }

    public String getEventActivity() {
        return EventActivity;
    }

    public void setEventActivity(String eventActivity) {
        EventActivity = eventActivity;
    }


    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }

    public String getEventCondition() {
        return EventCondition;
    }

    public void setEventCondition(String eventCondition) {
        EventCondition = eventCondition;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String eventLocation) {
        EventLocation = eventLocation;
    }

    public int getImages() {
        return EventImages;
    }

    public void setImages(int EventImages) {
        this.EventImages = EventImages;
    }
}
