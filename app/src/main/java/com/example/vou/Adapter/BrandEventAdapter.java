package com.example.vou.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.EventDetailActivity;
import com.example.vou.GameShakePhoneActivity;
import com.example.vou.Model.Event;
import com.example.vou.Model.Game;
import com.example.vou.Model.Voucher;
import com.example.vou.R;
import com.example.vou.Singleton.GameSingleton;
import com.example.vou.VoucherDetailActivity;

import java.time.temporal.Temporal;
import java.util.List;

public class BrandEventAdapter extends RecyclerView.Adapter<BrandEventAdapter.BrandEventViewHolder>{

    private List<Event> brandEvents;
    private static Context context;
    public BrandEventAdapter(List<Event> brandEvents, Context context) {
        this.brandEvents = brandEvents;
        this.context = context;
    }

    @Override
    public BrandEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_event_item, parent, false);
        return new BrandEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandEventViewHolder holder, int position) {
        ((BrandEventViewHolder) holder).bindData((Event) brandEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return brandEvents.size();
    }

    public static class BrandEventViewHolder extends RecyclerView.ViewHolder {
        LinearLayout brandEventLayout;
        ImageView brandEventImage, brandEventFavourite, brandEventPlayNow;
        TextView brandEventName, brandEventGenre;

        public BrandEventViewHolder(View itemView) {
            super(itemView);
            brandEventLayout = itemView.findViewById(R.id.item_brand_event);
            brandEventImage = itemView.findViewById(R.id.item_brand_event_image);
            brandEventFavourite = itemView.findViewById(R.id.item_brand_event_favourite);
            brandEventPlayNow = itemView.findViewById(R.id.item_brand_event_play_now);
            brandEventName = itemView.findViewById(R.id.item_brand_event_name);
            brandEventGenre = itemView.findViewById(R.id.item_brand_event_genre);
        }
        public void bindData(Event data) {
            brandEventImage.setImageResource(data.getImage());
            brandEventName.setText(data.getName());
            Game game = GameSingleton.getInstance().getGame(data.getGame_id());
            brandEventGenre.setText(game.getName_type());
            brandEventPlayNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = null;
                    if(data.getGame_id() == 1){

                    }
                    else if(data.getGame_id() == 2){
                        intent = new Intent(context, GameShakePhoneActivity.class);
                        intent.putExtra("event_data", data);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
