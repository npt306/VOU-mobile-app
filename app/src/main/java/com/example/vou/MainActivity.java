package com.example.vou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vou.Adapter.HomeBrandCategoryAdapter;
import com.example.vou.Adapter.HomeHotEventAdapter;
import com.example.vou.Adapter.HomeVoucherAdapter;
import com.example.vou.Model.Event;
import com.example.vou.Singleton.LoginSingleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView ivHomeProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        if(!LoginSingleton.getInstance().isLogging()){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        ViewPager2 viewPager = findViewById(R.id.homeVoucher);

        List<Integer> voucherImages = Arrays.asList(
                R.drawable.voucher_1,
                R.drawable.voucher_2,
                R.drawable.voucher_3
        );

        HomeVoucherAdapter homeVoucherAdapter = new HomeVoucherAdapter(voucherImages);
        viewPager.setAdapter(homeVoucherAdapter);

        RecyclerView recyclerViewHomeBrandCategory = findViewById(R.id.recyclerViewHomeBrandCategory);
        recyclerViewHomeBrandCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        int[] images = {R.drawable.logo_kfc, R.drawable.logo_lotteria, R.drawable.logo_mc_donald, R.drawable.logo_starbucks, R.drawable.logo_jollibee, R.drawable.logo_pizza_hut, R.drawable.logo_highlands, R.drawable.logo_gong_cha};
        String[] labels = {"KFC","Lotteria","McDonald's", "Starbucks", "Jollibee", "Pizza Hut", "Highlands", "Gong Cha"};

        HomeBrandCategoryAdapter adapterHomeBrandCategory = new HomeBrandCategoryAdapter(images,labels);
        recyclerViewHomeBrandCategory.setAdapter(adapterHomeBrandCategory);


        RecyclerView recyclerViewHomeHotVoucher = findViewById(R.id.recyclerViewHomeHotVoucher);
        recyclerViewHomeHotVoucher.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Event> events = new ArrayList<>();
        events.add(new Event(R.drawable.logo_kfc, "KFC", "20% sale"));
        events.add(new Event(R.drawable.logo_lotteria, "Lotteria", "10% sale"));
        events.add(new Event(R.drawable.logo_mc_donald, "McDonald's", "15% sale"));


        HomeHotEventAdapter adapterHomeHotEvent = new HomeHotEventAdapter(events);
        recyclerViewHomeHotVoucher.setAdapter(adapterHomeHotEvent);

        SearchView searchViewVoucher = findViewById(R.id.searchViewVoucher);

        searchViewVoucher.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Xử lý hành động khi người dùng gửi tìm kiếm
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Xử lý hành động khi người dùng nhập văn bản tìm kiếm
                return false;
            }
        });

        ivHomeProfile = findViewById(R.id.ivHomeProfile);
        ivHomeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyVoucherActivity.class);
                startActivity(intent);
            }
        });

    }
}