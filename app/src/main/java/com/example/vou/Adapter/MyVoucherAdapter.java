package com.example.vou.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.R;
import com.example.vou.Model.Voucher;
import com.example.vou.VoucherDetailActivity;

import java.util.List;

public class MyVoucherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VOUCHER_TYPE_1 = 1;
    private static final int VOUCHER_TYPE_2 = 2;
    private Context context;
    private List<Voucher> vouchers;

    public MyVoucherAdapter(List<Voucher> vouchers, Context context){
        this.vouchers = vouchers;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == VOUCHER_TYPE_1) {
            View view = inflater.inflate(R.layout.my_voucher_type_1_item, parent, false);
            return new MyVoucherType1ViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.my_voucher_type_2_item, parent, false);
            return new MyVoucherType2ViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return vouchers.get(position).getType();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyVoucherType1ViewHolder) {
            ((MyVoucherType1ViewHolder) holder).bindData((Voucher) vouchers.get(position));
        } else {
            ((MyVoucherType2ViewHolder) holder).bindData((Voucher) vouchers.get(position));
        }
    }


    @Override
    public int getItemCount(){
        return vouchers.size();
    }

    public class MyVoucherType1ViewHolder extends RecyclerView.ViewHolder{
        ImageView voucherImage, cartImage;
        TextView nameVoucher, saleVoucher, expiredDayVoucher;
        LinearLayout voucherLayout;
        public MyVoucherType1ViewHolder(@NonNull View itemView){
            super(itemView);
            voucherImage = itemView.findViewById(R.id.item_voucher_type_1_image);
            nameVoucher = itemView.findViewById(R.id.item_voucher_type_1_name);
            saleVoucher = itemView.findViewById(R.id.item_voucher_type_1_sale);
            expiredDayVoucher = itemView.findViewById(R.id.item_voucher_type_1_expired_day);
            cartImage = itemView.findViewById(R.id.item_voucher_type_1_use_now);
            voucherLayout = itemView.findViewById(R.id.item_voucher_type_1);
        }
        public void bindData(Voucher data) {
            voucherImage.setImageResource(data.getImage());
            nameVoucher.setText(data.getName());
            saleVoucher.setText(data.getSale() + " sale");
            expiredDayVoucher.setText(data.getExpiredDayString());
            cartImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            voucherLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, VoucherDetailActivity.class);
                    intent.putExtra("voucher", data);
                    context.startActivity(intent);
                }
            });
        }
    }
    public class MyVoucherType2ViewHolder extends RecyclerView.ViewHolder{
        ImageView voucherImage, cartImage;
        TextView nameVoucher, saleVoucher, expiredDayVoucher, totalPiecesVoucher, availablePiecesVoucher;
        LinearLayout voucherLayout;
        public MyVoucherType2ViewHolder(@NonNull View itemView){
            super(itemView);
            voucherImage = itemView.findViewById(R.id.item_voucher_type_2_image);
            nameVoucher = itemView.findViewById(R.id.item_voucher_type_2_name);
            saleVoucher = itemView.findViewById(R.id.item_voucher_type_2_sale);
            expiredDayVoucher = itemView.findViewById(R.id.item_voucher_type_2_expired_day);
            totalPiecesVoucher = itemView.findViewById(R.id.item_voucher_type_2_total_pieces);
            availablePiecesVoucher = itemView.findViewById(R.id.item_voucher_type_2_available_pieces);
            cartImage = itemView.findViewById(R.id.item_voucher_type_2_use_now);
            voucherLayout = itemView.findViewById(R.id.item_voucher_type_2);
        }
        public void bindData(Voucher data) {
            voucherImage.setImageResource(data.getImage());
            nameVoucher.setText(data.getName());
            saleVoucher.setText(data.getSale() + " sale");
            expiredDayVoucher.setText("Expired day: " + data.getExpiredDayString());
            totalPiecesVoucher.setText(String.valueOf(data.getTotalPieces()));
            availablePiecesVoucher.setText(String.valueOf(data.getAvailablePieces()));
            if(data.getTotalPieces() != data.getAvailablePieces()){
                cartImage.setImageResource(R.drawable.icon_cart_unavailable);
                cartImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Not enough piece for voucher", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else{
                cartImage.setImageResource(R.drawable.icon_cart);
                cartImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
            voucherLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, VoucherDetailActivity.class);
                    intent.putExtra("voucher", data);
                    context.startActivity(intent);
                }
            });
        }
    }
}

