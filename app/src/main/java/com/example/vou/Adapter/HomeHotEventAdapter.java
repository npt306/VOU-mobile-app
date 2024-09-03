package com.example.vou.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Model.Event;
import com.example.vou.R;

import java.util.List;

public class HomeHotEventAdapter extends RecyclerView.Adapter<HomeHotEventAdapter.HomeHotEventViewHolder> {
    private List<Event> events;
    public HomeHotEventAdapter(List<Event> events){
        this.events = events;
    }
    @Override
    public HomeHotEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_hot_event_item, parent, false);
        return new HomeHotEventViewHolder(view);
    }
    @Override
    public void onBindViewHolder(HomeHotEventViewHolder holder, int position){
        holder.event_image.setImageResource(events.get(position).getImageResourceId());
        holder.event_name.setText(events.get(position).getEventName());
        holder.event_sale.setText(events.get(position).getEventSale());
    }
    @Override
    public int getItemCount(){
        return events.size();
    }

    public class HomeHotEventViewHolder extends RecyclerView.ViewHolder{
        ImageView event_image;
        TextView event_name;
        TextView event_sale;

        public HomeHotEventViewHolder(View itemView){
            super(itemView);
            event_image = itemView.findViewById(R.id.item_hot_event_image);
            event_name = itemView.findViewById(R.id.item_hot_event_name);
            event_sale = itemView.findViewById(R.id.item_hot_event_sale);
        }
    }
}
