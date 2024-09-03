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
                Log.d("My Voucher", "Back button pressed");
            }
        });


        RecyclerView myVoucherRecyclerView = findViewById(R.id.recyclerViewMyVoucher);
        List<Voucher> vouchers  = new ArrayList<>();
        vouchers.add(new Voucher("KFC Breakfast Voucher", "GIE9CK", "Enjoy a delicious chicken breakfast at KFC with this voucher. Save 20% on your next morning meal.", new Date(2024,9,2), "20%"));
        vouchers.add(new Voucher("Starbucks Coffee Discount", "SBX4RT", "Get 15% off on any coffee order at Starbucks. Perfect for your morning or afternoon pick-me-up.", new Date(2024,9,15), "15%"));
        vouchers.add(new Voucher("Pizza Hut Large Pizza Deal", "PZHLRG", "Order a large pizza at Pizza Hut and get 25% off. Treat your friends and family!", new Date(2024,10,1), "25%"));
        vouchers.add(new Voucher("McDonald's Happy Meal", "MC1HAP", "Enjoy a Happy Meal at McDonald's with a 10% discount. Great for kids and adults alike.", new Date(2024,9,30), "10%"));
        vouchers.add(new Voucher("Subway Sandwich Special", "SBW3SP", "Buy any footlong sandwich at Subway and save 15%. A perfect deal for sandwich lovers.", new Date(2024,10,5), "15%"));

        vouchers.add(new Voucher("Burger King Whopper Deal", "BK9WHP", "Get 20% off on any Whopper at Burger King. Satisfy your hunger with a juicy burger.", new Date(2024,9,25), "20%",1,3));
        vouchers.add(new Voucher("Domino's Pizza Combo", "DMO7CB", "Order a pizza combo at Domino's and enjoy 30% off. Ideal for family dinners.", new Date(2024,10,10), "30%",2,3));
        vouchers.add(new Voucher("Dunkin' Donuts Coffee & Donut", "DD5CND", "Save 15% on any coffee and donut combo at Dunkin' Donuts. Start your day sweetly.", new Date(2024,9,12), "15%",1,3));
        vouchers.add(new Voucher("Taco Bell Meal Deal", "TCB9MD", "Get 20% off on any meal at Taco Bell. Perfect for a quick and tasty meal.", new Date(2024,9,22), "20%",3,3));
        vouchers.add(new Voucher("KFC Family Bucket", "KFC4FAM", "Enjoy a KFC Family Bucket with 25% off. A great deal for family gatherings.", new Date(2024,10,15), "25%",1,3));

        vouchers.add(new Voucher("Starbucks Frappuccino Discount", "SBXFRC", "Cool down with a 10% discount on any Frappuccino at Starbucks.", new Date(2024,9,18), "10%"));
        vouchers.add(new Voucher("McDonald's Big Mac Deal", "MC2BMC", "Get 15% off on any Big Mac at McDonald's. A classic burger at a great price.", new Date(2024,9,28), "15%"));
        vouchers.add(new Voucher("Pizza Hut Pasta Special", "PZHPST", "Order any pasta dish at Pizza Hut and save 20%. Perfect for pasta lovers.", new Date(2024,10,12), "20%"));
        vouchers.add(new Voucher("Subway Breakfast Combo", "SBW4BF", "Save 10% on any breakfast combo at Subway. Start your morning right.", new Date(2024,9,14), "10%"));
        vouchers.add(new Voucher("Burger King Breakfast Deal", "BK7BRF", "Enjoy 20% off on any breakfast item at Burger King. A great start to your day.", new Date(2024,9,26), "20%"));

        vouchers.add(new Voucher("Domino's Dessert Special", "DMO9DS", "Get 15% off on any dessert at Domino's. Perfect for satisfying your sweet tooth.", new Date(2024,10,8), "15%"));
        vouchers.add(new Voucher("Dunkin' Donuts Bagel & Coffee", "DD7BGC", "Save 20% on any bagel and coffee combo at Dunkin' Donuts.", new Date(2024,9,16), "20%"));
        vouchers.add(new Voucher("Taco Bell Burrito Deal", "TCB6BR", "Get 25% off on any burrito at Taco Bell. A deal too good to pass up.", new Date(2024,9,20), "25%"));

        vouchers.add(new Voucher("KFC Zinger Burger Special", "KFC6ZNG", "Enjoy 20% off on a Zinger Burger at KFC. Crispy and spicy, just the way you like it.", new Date(2024,10,1), "20%"));
        vouchers.add(new Voucher("Starbucks Tea Time Discount", "SBX9TEA", "Get 15% off on any tea at Starbucks. Relax with a refreshing cup of tea.", new Date(2024,9,24), "15%"));
        vouchers.add(new Voucher("McDonald's McFlurry Deal", "MC4MFL", "Save 10% on any McFlurry at McDonald's. A cool treat on a hot day.", new Date(2024,9,30), "10%"));

        MyVoucherAdapter myVoucherAdapter = new MyVoucherAdapter(vouchers, this);
        myVoucherRecyclerView.setAdapter(myVoucherAdapter);
        myVoucherRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
