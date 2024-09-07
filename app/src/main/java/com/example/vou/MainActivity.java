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
import com.example.vou.Model.Brand;
import com.example.vou.Model.Event;
import com.example.vou.Model.Game;
import com.example.vou.Singleton.BrandSingleton;
import com.example.vou.Singleton.EventSingleton;
import com.example.vou.Singleton.GameSingleton;
import com.example.vou.Singleton.LoginSingleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

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

        testData();

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

        HomeBrandCategoryAdapter adapterHomeBrandCategory = new HomeBrandCategoryAdapter(BrandSingleton.getInstance().getBrandList(), MainActivity.this);
        recyclerViewHomeBrandCategory.setAdapter(adapterHomeBrandCategory);

        RecyclerView recyclerViewHomeHotVoucher = findViewById(R.id.recyclerViewHomeHotVoucher);
        recyclerViewHomeHotVoucher.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        HomeHotEventAdapter adapterHomeHotEvent = new HomeHotEventAdapter(EventSingleton.getInstance().getEventList());
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
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
    public void testData(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.SEPTEMBER, 10);
        Date startDate1 = calendar.getTime();
        calendar.set(2024, Calendar.SEPTEMBER, 20);
        Date endDate1 = calendar.getTime();
        calendar.set(2024, Calendar.OCTOBER, 1);
        Date startDate2 = calendar.getTime();
        calendar.set(2024, Calendar.OCTOBER, 15);
        Date endDate2 = calendar.getTime();
        calendar.set(2024, Calendar.NOVEMBER, 5);
        Date startDate3 = calendar.getTime();
        calendar.set(2024, Calendar.NOVEMBER, 25);
        Date endDate3 = calendar.getTime();
        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event(1, "KFC Golden Week", "Get amazing discounts at KFC!", R.drawable.logo_kfc, 100, 20, startDate1, endDate1, 1, 1, 5,"Buy 1 get 1 free on selected items.", Arrays.asList(1001, 1002, 1003)));
        eventList.add(new Event(2, "Lotteria Mega Deal", "Special offers at Lotteria.", R.drawable.logo_lotteria, 200, 50, startDate1, endDate1, 2, 2, 5, "Up to 50% off on all meals.", Arrays.asList(1004, 1005, 1006)));
        eventList.add(new Event(3, "McDonald's Happy Days", "Enjoy delicious meals at McDonald's.", R.drawable.logo_mc_donald, 150, 30, startDate2, endDate2, 3, 1, 5, "Free fries with any burger purchase.", Arrays.asList(1007, 1008, 1009)));
        eventList.add(new Event(4, "Starbucks Coffee Lover", "Exclusive discounts for coffee lovers.", R.drawable.logo_starbucks, 250, 100, startDate2, endDate2, 4, 2, 5, "Buy any coffee and get a second one at 50% off.", Arrays.asList(1010, 1011, 1012)));
        eventList.add(new Event(5, "Jollibee Family Feast", "Big savings for the whole family at Jollibee.", R.drawable.logo_jollibee, 120, 25, startDate1, endDate2, 5, 1, 5, "Family meal deal with extra sides.", Arrays.asList(1013, 1014, 1015)));
        eventList.add(new Event(6, "Pizza Hut Double Deal", "Get two large pizzas at a special price.", R.drawable.logo_pizza_hut, 180, 40, startDate2, endDate3, 6, 2, 5, "Order any large pizza and get the second one at 50% off.", Arrays.asList(1016, 1017, 1018)));
        eventList.add(new Event(7, "Highlands Coffee Fest", "Enjoy a variety of coffees at Highlands.", R.drawable.logo_highlands, 220, 60, startDate3, endDate3, 7, 1, 5, "Buy one, get one free on selected coffee.", Arrays.asList(1019, 1020, 1021)));
        eventList.add(new Event(8, "Gong Cha Bubble Mania", "Special offers on bubble tea at Gong Cha.", R.drawable.logo_gong_cha, 140, 35, startDate3, endDate3, 8, 2, 5, "Get a free topping with any drink.", Arrays.asList(1022, 1023, 1024)));
        EventSingleton.getInstance().setEventList(eventList);

        List<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand(1, "KFC", "Fast Food", "123 Main St, District 1", "10.7769, 106.7009", true, "contact@kfc.com", R.drawable.logo_kfc));
        brandList.add(new Brand(2, "Lotteria", "Fast Food", "456 Nguyen Hue, District 1", "10.7769, 106.7010", true, "contact@lotteria.com", R.drawable.logo_lotteria));
        brandList.add(new Brand(3, "McDonald's", "Fast Food", "789 Le Duan, District 1", "10.7770, 106.7011", true, "contact@mcdonalds.com", R.drawable.logo_mc_donald));
        brandList.add(new Brand(4, "Starbucks", "Coffee", "321 Hai Ba Trung, District 3", "10.7771, 106.7012", true, "contact@starbucks.com", R.drawable.logo_starbucks));
        brandList.add(new Brand(5, "Jollibee", "Fast Food", "654 Tran Hung Dao, District 5", "10.7772, 106.7013", true, "contact@jollibee.com", R.drawable.logo_jollibee));
        brandList.add(new Brand(6, "Pizza Hut", "Pizza", "987 Pham Ngu Lao, District 1", "10.7773, 106.7014", true, "contact@pizzahut.com", R.drawable.logo_pizza_hut));
        brandList.add(new Brand(7, "Highlands", "Coffee", "159 Dong Khoi, District 1", "10.7774, 106.7015", true, "contact@highlandscoffee.com", R.drawable.logo_highlands));
        brandList.add(new Brand(8, "Gong Cha", "Bubble Tea", "753 Ly Tu Trong, District 1", "10.7775, 106.7016", true, "contact@gongcha.com", R.drawable.logo_gong_cha));
        BrandSingleton.getInstance().setBrandList(brandList);

        List<Game> gameList = new ArrayList<>();
        gameList.add(new Game(1, "Quiz", 101, 1, false, "Quiz", "Answer questions to win points."));
        gameList.add(new Game(2, "Lucky shake", 102, 2, false, "Lucky shake", "Shake your phone to reveal rewards."));
        GameSingleton.getInstance().setGameList(gameList);

        EventSingleton.getInstance().addFavouriteEvent(1);
        EventSingleton.getInstance().addFavouriteEvent(2);
        EventSingleton.getInstance().addFavouriteEvent(3);

    }
}