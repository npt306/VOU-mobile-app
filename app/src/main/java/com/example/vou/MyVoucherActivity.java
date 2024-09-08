package com.example.vou;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Adapter.MyVoucherAdapter;
import com.example.vou.Model.Voucher;
import com.example.vou.Singleton.VoucherSingleton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyVoucherActivity extends AppCompatActivity {
    ImageView myVoucherBackButton;
    private ToggleButton toggleNew, toggleFood, toggleExpired;
    private RecyclerView recyclerViewVouchers;
    private List<Voucher> allVouchers;
    private List<Voucher> filteredVouchers;
    private MyVoucherAdapter voucherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_voucher);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.my_voucher_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myVoucherBackButton = findViewById(R.id.myVoucherBackButton);
        myVoucherBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        RecyclerView myVoucherRecyclerView = findViewById(R.id.recyclerViewMyVoucher);
        MyVoucherAdapter myVoucherAdapter = new MyVoucherAdapter(VoucherSingleton.getInstance().getMyVoucherList(), this);
        myVoucherRecyclerView.setAdapter(myVoucherAdapter);
        myVoucherRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
