package com.example.vou.Singleton;

import android.util.Log;

import com.example.vou.Model.Brand;
import com.example.vou.Model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventSingleton {
    private static EventSingleton instance;
    private List<Event> eventList;
    private List<Event> favouriteEventList = new ArrayList<>();
    private EventSingleton() {}

    public static EventSingleton getInstance() {
        if (instance == null) {
            instance = new EventSingleton();
        }
        return instance;
    }

    public List<Event> getFavouriteEventList() {
        return favouriteEventList;
    }

    public void setFavouriteEventList(List<Event> favouriteEventList) {
        this.favouriteEventList = favouriteEventList;
    }

    public void updateNumberOfTurn(int eventId, int number_of_turn){
        for(int i = 0; i < eventList.size(); i++){
            if(eventList.get(i).getId() == eventId){
                eventList.get(i).setNum_of_turn(number_of_turn);
                return;
            }
        }
    }

    public int getNumberOfTurn(int eventId){
        for(int i = 0; i < eventList.size(); i++){
            if(eventList.get(i).getId() == eventId){
                return eventList.get(i).getNum_of_turn();
            }
        }
        return 0;
    }

    public void addFavouriteEvent(int eventId) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getId() == eventId) {
                boolean isAlreadyInFavourite = false;

                for (int j = 0; j < favouriteEventList.size(); j++) {
                    if (favouriteEventList.get(j).getId() == eventId) {
                        isAlreadyInFavourite = true;
                        break;
                    }
                }

                if (!isAlreadyInFavourite) {
                    favouriteEventList.add(eventList.get(i));
                }

            }
        }
    }


    public void removeFavouriteEvent(int eventId){
        for(int i = 0; i < favouriteEventList.size(); i++){
            if (favouriteEventList.get(i).getId() == eventId){
                favouriteEventList.remove(i);
                return;
            }
        }
    }

    public boolean isFavouriteEvent(int eventId){
        for(int i = 0; i < favouriteEventList.size(); i++){
            if (favouriteEventList.get(i).getId() == eventId){
                return true;
            }
        }
        return false;
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
