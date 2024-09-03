package com.example.vou.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.R;

public class HomeBrandCategoryAdapter extends RecyclerView.Adapter<HomeBrandCategoryAdapter.HomeBrandCategoryViewHolder> {
    private int[] images;
    private String[] labels;
    public HomeBrandCategoryAdapter(int[] images, String[] labels){
        this.images = images;
        this.labels = labels;
    }
    @Override
    public HomeBrandCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_item, parent, false);
        return new HomeBrandCategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(HomeBrandCategoryViewHolder holder, int position){
        holder.brand_image.setImageResource(images[position]);
        holder.brand_label.setText(labels[position]);
    }
    @Override
    public int getItemCount(){
        return labels.length;
    }

    public class HomeBrandCategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView brand_image;
        TextView brand_label;

        public HomeBrandCategoryViewHolder(View itemView){
            super(itemView);
            brand_image = itemView.findViewById(R.id.item_brand_image);
            brand_label = itemView.findViewById(R.id.item_brand_label);
        }
    }
}
