package com.example.vou;

public class HotEvent {
    private int imageResourceId;
    private String eventName;
    private String eventSale;

    // Constructor
    public HotEvent(int imageResourceId, String eventName, String eventDescription) {
        this.imageResourceId = imageResourceId;
        this.eventName = eventName;
        this.eventSale = eventDescription;
    }

    // Getter và Setter cho imageResourceId
    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    // Getter và Setter cho eventName
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    // Getter và Setter cho eventDescription
    public String getEventSale() {
        return eventSale;
    }

    public void setEventSale(String eventSale) {
        this.eventSale = eventSale;
    }
}
