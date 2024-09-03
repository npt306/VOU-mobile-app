package com.example.vou.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.R;

import java.util.List;

public class HomeVoucherAdapter extends RecyclerView.Adapter<HomeVoucherAdapter.HomeVoucherViewHolder> {

    private final List<Integer> voucherImages;

    public HomeVoucherAdapter(List<Integer> voucherImages) {
        this.voucherImages = voucherImages;
    }

    @Override
    public HomeVoucherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_voucher_item, parent, false);
        return new HomeVoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeVoucherViewHolder holder, int position) {
        holder.voucherImage.setImageResource(voucherImages.get(position));
    }

    @Override
    public int getItemCount() {
        return voucherImages.size();
    }

    public static class HomeVoucherViewHolder extends RecyclerView.ViewHolder {
        ImageView voucherImage;

        public HomeVoucherViewHolder(View itemView) {
            super(itemView);
            voucherImage = itemView.findViewById(R.id.voucherImage);
        }
    }
}
