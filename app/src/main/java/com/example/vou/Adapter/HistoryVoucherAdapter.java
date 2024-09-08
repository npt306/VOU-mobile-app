package com.example.vou.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Model.Voucher;
import com.example.vou.R;

import java.util.List;

public class HistoryVoucherAdapter extends RecyclerView.Adapter<HistoryVoucherAdapter.HistoryVoucherViewHolder> {
    private List<Voucher> historyVoucherList;
    Context context;
    public HistoryVoucherAdapter(List<Voucher> historyVoucherList, Context context){
        this.historyVoucherList = historyVoucherList;
        this.context = context;
    }
    @NonNull
    @Override
    public HistoryVoucherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_voucher_item, parent, false);
        return new HistoryVoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryVoucherViewHolder holder, int position){
        holder.voucherName.setText(historyVoucherList.get(position).getName());
        holder.voucherSale.setText(historyVoucherList.get(position).getSale());
        holder.voucherImage.setImageResource(historyVoucherList.get(position).getImage());
    }

    @Override
    public int getItemCount(){
        return historyVoucherList.size();
    }

    public class HistoryVoucherViewHolder extends RecyclerView.ViewHolder{
        TextView voucherName, voucherSale;
        ImageView voucherImage;
        HistoryVoucherViewHolder(View itemView){
            super(itemView);
            voucherName = itemView.findViewById(R.id.item_histoty_voucher_name);
            voucherSale = itemView.findViewById(R.id.item_history_voucher_sale);
            voucherImage = itemView.findViewById(R.id.item_history_voucher_image);
        }
    }
}
