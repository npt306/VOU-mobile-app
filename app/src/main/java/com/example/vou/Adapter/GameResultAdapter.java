package com.example.vou.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Model.Voucher;
import com.example.vou.R;
import com.example.vou.Singleton.VoucherSingleton;

import java.util.List;

public class GameResultAdapter extends RecyclerView.Adapter<GameResultAdapter.GameResultViewHolder> {

    List<Integer> resultList;
    public GameResultAdapter(List<Integer> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public GameResultAdapter.GameResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_game_voucher_item, parent, false);
        return new GameResultAdapter.GameResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameResultAdapter.GameResultViewHolder holder, int position) {
        Voucher voucher = VoucherSingleton.getInstance().getVoucher(resultList.get(position));
        holder.voucherName.setText(voucher.getName());
        holder.voucherImage.setImageResource(voucher.getImage());
        holder.voucherDescription.setText(voucher.getDescription());
        if(voucher.getType() == 1){
            holder.piecesLayout.setVisibility(View.GONE);
        }
        if(voucher.getType() == 2){
            holder.totalPieces.setText(String.valueOf(voucher.getTotalPieces()));
            holder.availablePieces.setText(String.valueOf(voucher.getAvailablePieces()));
        }
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class GameResultViewHolder extends RecyclerView.ViewHolder {
        TextView voucherName, voucherDescription, totalPieces, availablePieces;
        ImageView voucherImage;
        LinearLayout piecesLayout;

        GameResultViewHolder(View itemView) {
            super(itemView);
            voucherName = itemView.findViewById(R.id.item_result_game_voucher_name);
            voucherDescription = itemView.findViewById(R.id.item_result_game_voucher_short_description);
            voucherImage = itemView.findViewById(R.id.item_result_game_voucher_image);
            totalPieces = itemView.findViewById(R.id.item_result_game_voucher_total_pieces);
            availablePieces = itemView.findViewById(R.id.item_result_game_voucher_available_pieces);
            piecesLayout = itemView.findViewById(R.id.item_result_game_voucher_pieces);
        }
    }
}