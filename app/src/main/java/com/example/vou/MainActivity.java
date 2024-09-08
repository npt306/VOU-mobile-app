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
import com.example.vou.Model.User;
import com.example.vou.Model.Voucher;
import com.example.vou.Singleton.BrandSingleton;
import com.example.vou.Singleton.EventSingleton;
import com.example.vou.Singleton.GameSingleton;
import com.example.vou.Singleton.LoginSingleton;
import com.example.vou.Singleton.UserSingleton;
import com.example.vou.Singleton.VoucherSingleton;

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

        List<User> users = new ArrayList<>();

        users.add(new User(1, "johndoe", "johndoe@example.com", "John Doe", "password123", "1234567890", true, 1, 101, new Date(95, 4, 10), "facebook.com/johndoe"));
        users.add(new User(2, "janedoe", "janedoe@example.com", "Jane Doe", "password456", "0987654321", false, 0, 102, new Date(98, 6, 15), "facebook.com/janedoe"));
        users.add(new User(3, "mikesmith", "mikesmith@example.com", "Mike Smith", "password789", "9876543210", true, 1, 103, new Date(90, 11, 5), "facebook.com/mikesmith"));
        users.add(new User(4, "annlee", "annlee@example.com", "Ann Lee", "password000", "1234509876", false, 0, 104, new Date(92, 9, 20), "facebook.com/annlee"));
        users.add(new User(5, "bobjones", "bobjones@example.com", "Bob Jones", "password111", "1122334455", true, 1, 105, new Date(85, 2, 25), "facebook.com/bobjones"));
        users.add(new User(6, "lucysky", "lucysky@example.com", "Lucy Sky", "password222", "9988776655", false, 0, 106, new Date(99, 7, 18), "facebook.com/lucysky"));
        users.add(new User(7, "peterbrown", "peterbrown@example.com", "Peter Brown", "password333", "3344556677", true, 1, 107, new Date(87, 3, 12), "facebook.com/peterbrown"));
        users.add(new User(8, "sarawhite", "sarawhite@example.com", "Sara White", "password444", "5566778899", false, 0, 108, new Date(93, 8, 8), "facebook.com/sarawhite"));
        users.add(new User(9, "steveblack", "steveblack@example.com", "Steve Black", "password555", "6677889900", true, 1, 109, new Date(91, 1, 14), "facebook.com/steveblack"));
        users.add(new User(10, "lisagreen", "lisagreen@example.com", "Lisa Green", "password666", "7788990011", false, 0, 110, new Date(96, 5, 22), "facebook.com/lisagreen"));
        users.add(new User(11, "kevinblue", "kevinblue@example.com", "Kevin Blue", "password777", "2233445566", true, 1, 111, new Date(89, 10, 17), "facebook.com/kevinblue"));
        users.add(new User(12, "emmared", "emmared@example.com", "Emma Red", "password888", "4433221100", false, 0, 112, new Date(97, 2, 9), "facebook.com/emmared"));
        users.add(new User(13, "davidsilver", "davidsilver@example.com", "David Silver", "password999", "2345678901", true, 1, 113, new Date(86, 11, 13), "facebook.com/davidsilver"));
        users.add(new User(14, "cindywhite", "cindywhite@example.com", "Cindy White", "password000", "9988007766", false, 0, 114, new Date(84, 4, 27), "facebook.com/cindywhite"));
        users.add(new User(15, "markgreen", "markgreen@example.com", "Mark Green", "passwordabc", "1098765432", true, 1, 115, new Date(88, 7, 19), "facebook.com/markgreen"));
        users.add(new User(16, "susantaylor", "susantaylor@example.com", "Susan Taylor", "passwordxyz", "3216549870", false, 0, 116, new Date(83, 12, 21), "facebook.com/susantaylor"));
        users.add(new User(17, "charlesbrown", "charlesbrown@example.com", "Charles Brown", "passworddef", "8765432109", true, 1, 117, new Date(82, 6, 6), "facebook.com/charlesbrown"));
        users.add(new User(18, "paularichards", "paularichards@example.com", "Paula Richards", "passwordghi", "5647382910", false, 0, 118, new Date(81, 9, 30), "facebook.com/paularichards"));
        users.add(new User(19, "georgeyoung", "georgeyoung@example.com", "George Young", "passwordjkl", "0192837465", true, 1, 119, new Date(80, 10, 2), "facebook.com/georgeyoung"));
        users.add(new User(20, "rachelblue", "rachelblue@example.com", "Rachel Blue", "passwordmno", "9876543012", false, 0, 120, new Date(79, 3, 5), "facebook.com/rachelblue"));
        UserSingleton.getInstance().setUserList(users);

        UserSingleton.getInstance().addFriend(1);
        UserSingleton.getInstance().addFriend(3);
        UserSingleton.getInstance().addFriend(5);
        UserSingleton.getInstance().addFriend(7);
        UserSingleton.getInstance().addFriend(9);

        List<Voucher> voucherList  = new ArrayList<>();
        voucherList.add(new Voucher(1,"KFC Breakfast Voucher", "GIE9CK", "Enjoy a delicious chicken breakfast at KFC with this voucher. Save 20% on your next morning meal.", new Date(2024,9,2), "20%"));
        voucherList.add(new Voucher(2,"Starbucks Coffee Discount", "SBX4RT", "Get 15% off on any coffee order at Starbucks. Perfect for your morning or afternoon pick-me-up.", new Date(2024,9,15), "15%"));
        voucherList.add(new Voucher(3,"Pizza Hut Large Pizza Deal", "PZHLRG", "Order a large pizza at Pizza Hut and get 25% off. Treat your friends and family!", new Date(2024,10,1), "25%"));
        voucherList.add(new Voucher(4,"McDonald's Happy Meal", "MC1HAP", "Enjoy a Happy Meal at McDonald's with a 10% discount. Great for kids and adults alike.", new Date(2024,9,30), "10%"));
        voucherList.add(new Voucher(5,"Subway Sandwich Special", "SBW3SP", "Buy any footlong sandwich at Subway and save 15%. A perfect deal for sandwich lovers.", new Date(2024,10,5), "15%"));
        voucherList.add(new Voucher(6, "Burger King Whopper Deal", "BK9WHP", "Get 20% off on any Whopper at Burger King. Satisfy your hunger with a juicy burger.", new Date(2024,9,25), "20%",1,3));
        voucherList.add(new Voucher(7, "Domino's Pizza Combo", "DMO7CB", "Order a pizza combo at Domino's and enjoy 30% off. Ideal for family dinners.", new Date(2024,10,10), "30%",2,3));
        voucherList.add(new Voucher(8, "Dunkin' Donuts Coffee & Donut", "DD5CND", "Save 15% on any coffee and donut combo at Dunkin' Donuts. Start your day sweetly.", new Date(2024,9,12), "15%",1,3));
        voucherList.add(new Voucher(9, "Taco Bell Meal Deal", "TCB9MD", "Get 20% off on any meal at Taco Bell. Perfect for a quick and tasty meal.", new Date(2024,9,22), "20%",3,3));
        voucherList.add(new Voucher(10, "KFC Family Bucket", "KFC4FAM", "Enjoy a KFC Family Bucket with 25% off. A great deal for family gatherings.", new Date(2024,10,15), "25%",1,3));
        voucherList.add(new Voucher(11, "Starbucks Frappuccino Discount", "SBXFRC", "Cool down with a 10% discount on any Frappuccino at Starbucks.", new Date(2024,9,18), "10%"));
        voucherList.add(new Voucher(12, "McDonald's Big Mac Deal", "MC2BMC", "Get 15% off on any Big Mac at McDonald's. A classic burger at a great price.", new Date(2024,9,28), "15%"));
        voucherList.add(new Voucher(13, "Pizza Hut Pasta Special", "PZHPST", "Order any pasta dish at Pizza Hut and save 20%. Perfect for pasta lovers.", new Date(2024,10,12), "20%"));
        voucherList.add(new Voucher(14, "Subway Breakfast Combo", "SBW4BF", "Save 10% on any breakfast combo at Subway. Start your morning right.", new Date(2024,9,14), "10%"));
        voucherList.add(new Voucher(15, "Burger King Breakfast Deal", "BK7BRF", "Enjoy 20% off on any breakfast item at Burger King. A great start to your day.", new Date(2024,9,26), "20%"));
        voucherList.add(new Voucher(16, "Domino's Dessert Special", "DMO9DS", "Get 15% off on any dessert at Domino's. Perfect for satisfying your sweet tooth.", new Date(2024,10,8), "15%"));
        voucherList.add(new Voucher(17, "Dunkin' Donuts Bagel & Coffee", "DD7BGC", "Save 20% on any bagel and coffee combo at Dunkin' Donuts.", new Date(2024,9,16), "20%"));
        voucherList.add(new Voucher(18, "Taco Bell Burrito Deal", "TCB6BR", "Get 25% off on any burrito at Taco Bell. A deal too good to pass up.", new Date(2024,9,20), "25%"));
        voucherList.add(new Voucher(19, "KFC Zinger Burger Special", "KFC6ZNG", "Enjoy 20% off on a Zinger Burger at KFC. Crispy and spicy, just the way you like it.", new Date(2024,10,1), "20%"));
        voucherList.add(new Voucher(20, "Starbucks Tea Time Discount", "SBX9TEA", "Get 15% off on any tea at Starbucks. Relax with a refreshing cup of tea.", new Date(2024,9,24), "15%"));
        voucherList.add(new Voucher(21, "McDonald's McFlurry Deal", "MC4MFL", "Save 10% on any McFlurry at McDonald's. A cool treat on a hot day.", new Date(2024,9,30), "10%"));
        VoucherSingleton.getInstance().setVoucherList(voucherList);

        VoucherSingleton.getInstance().addMyVoucher(1);
        VoucherSingleton.getInstance().addMyVoucher(2);
        VoucherSingleton.getInstance().addMyVoucher(3);
        VoucherSingleton.getInstance().addMyVoucher(4);
        VoucherSingleton.getInstance().addMyVoucher(5);
        VoucherSingleton.getInstance().addMyVoucher(6);
        VoucherSingleton.getInstance().addMyVoucher(7);
        VoucherSingleton.getInstance().addMyVoucher(8);
        VoucherSingleton.getInstance().addMyVoucher(9);
        VoucherSingleton.getInstance().addMyVoucher(10);
        VoucherSingleton.getInstance().addMyVoucher(11);
        VoucherSingleton.getInstance().addMyVoucher(12);
        VoucherSingleton.getInstance().addMyVoucher(13);
        VoucherSingleton.getInstance().addMyVoucher(14);
        VoucherSingleton.getInstance().addMyVoucher(15);

        VoucherSingleton.getInstance().addHistoryVoucher(16);
        VoucherSingleton.getInstance().addHistoryVoucher(17);
        VoucherSingleton.getInstance().addHistoryVoucher(18);
        VoucherSingleton.getInstance().addHistoryVoucher(19);
        VoucherSingleton.getInstance().addHistoryVoucher(20);
    }
}