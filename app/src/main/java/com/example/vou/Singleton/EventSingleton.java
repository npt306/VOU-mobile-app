package com.example.vou.Singleton;

import com.example.vou.Model.Brand;
import com.example.vou.Model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventSingleton {
    private static EventSingleton instance;
    private List<Event> eventList;
    private EventSingleton() {}

    public static EventSingleton getInstance() {
        if (instance == null) {
            instance = new EventSingleton();
        }
        return instance;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public int getTotalEvent(){
        return eventList.size();
    }

    public int getNumberEventBrand(int brandId){
        int quantity = 0;
        for(int i = 0; i < eventList.size(); i++){
            if(eventList.get(i).getBrand_id() == brandId){
                quantity = quantity + 1;
            }
        }
        return quantity;
    }

    public List<Event> getEventListBrand(int brandId){
        List<Event> brandEventList = new ArrayList<>();
        for (int i = 0; i < eventList.size(); i++){
            if(eventList.get(i).getBrand_id() == brandId){
                brandEventList.add(eventList.get(i));
            }
        }
        return brandEventList;
    }
}
