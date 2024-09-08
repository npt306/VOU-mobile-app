package com.example.vou.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.vou.MainActivity;
import com.example.vou.Model.User;
import com.example.vou.R;
import com.example.vou.Singleton.UserSingleton;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder>{

    private List<User> userList;
    Context context;
    @NonNull
    @Override
    public FriendAdapter.FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item, parent, false);
        return new FriendAdapter.FriendViewHolder(view);
    }

    public FriendAdapter(List<User> userList, Context context){
        this.context = context;
        this.userList = userList;
    }
    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.FriendViewHolder holder, int position) {
        holder.userName.setText(userList.get(position).getUsername());
        holder.userEmail.setText(userList.get(position).getEmail());
        if(UserSingleton.getInstance().isFriend(userList.get(position).getId())){
            holder.addFriendButton.setVisibility(View.GONE);
            holder.giveVoucherButton.setVisibility(View.VISIBLE);
        }
        else {
            holder.addFriendButton.setVisibility(View.VISIBLE);
            holder.giveVoucherButton.setVisibility(View.GONE);
        }
        holder.giveVoucherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Xác nhận");
                builder.setMessage("Xác nhận tặng voucher");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Tặng voucher thành công", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class FriendViewHolder extends RecyclerView.ViewHolder {
        TextView userName, userEmail;
        ImageView giveVoucherButton, addFriendButton;
        FriendViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.item_friend_name);
            userEmail = itemView.findViewById(R.id.item_friend_email);
            giveVoucherButton = itemView.findViewById(R.id.item_friend_give_voucher);
            addFriendButton = itemView.findViewById(R.id.item_friend_add_friend);
        }
    }
}
