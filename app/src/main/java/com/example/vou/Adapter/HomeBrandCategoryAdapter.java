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

import com.example.vou.BrandEventActivity;
import com.example.vou.Model.Brand;
import com.example.vou.Model.Voucher;
import com.example.vou.R;
import com.example.vou.VoucherDetailActivity;

import java.util.List;

public class HomeBrandCategoryAdapter extends RecyclerView.Adapter<HomeBrandCategoryAdapter.HomeBrandCategoryViewHolder> {

    private List<Brand> brandList;
    Context context;
    public HomeBrandCategoryAdapter(List<Brand> brandList, Context context){
        this.brandList = brandList;
        this.context = context;
    }
    @Override
    public HomeBrandCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_item, parent, false);
        return new HomeBrandCategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(HomeBrandCategoryViewHolder holder, int position){
        ((HomeBrandCategoryAdapter.HomeBrandCategoryViewHolder) holder).bindData((Brand) brandList.get(position));
    }
    @Override
    public int getItemCount(){
        return brandList.size();
    }

    public class HomeBrandCategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView brand_image;
        TextView brand_label;
        LinearLayout brand_layout;

        public HomeBrandCategoryViewHolder(View itemView){
            super(itemView);
            brand_image = itemView.findViewById(R.id.item_brand_image);
            brand_label = itemView.findViewById(R.id.item_brand_label);
            brand_layout = itemView.findViewById(R.id.item_brand);
        }
        public void bindData(Brand data){
            brand_image.setImageResource(data.getImage());
            brand_label.setText(data.getName());
            brand_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BrandEventActivity.class);
                    intent.putExtra("brand", data);
                    context.startActivity(intent);
                }
            });
        }
    }
}
