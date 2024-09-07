package com.example.vou;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Adapter.BrandEventAdapter;
import com.example.vou.Model.Brand;
import com.example.vou.Model.Event;
import com.example.vou.Singleton.EventSingleton;

import java.util.List;

public class FavouriteEventActivity extends AppCompatActivity {
    private Context context;
    private ImageView favouriteEventBackButton;
    private ToggleButton toggleNew, toggleHot, toggleGood;
    private RecyclerView favouriteEventRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favourite_event);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.favourite_event_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        context = this;

        favouriteEventBackButton = findViewById(R.id.favourite_event_back_button);
        toggleNew = findViewById(R.id.favouriteEventToggleNew);
        toggleHot = findViewById(R.id.favouriteEventToggleHot);
        toggleGood = findViewById(R.id.favouriteEventToggleGood);
        favouriteEventRecyclerView = findViewById(R.id.recyclerViewFavouriteEvent);

        favouriteEventBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        List<Event> favouriteEventList = EventSingleton.getInstance().getFavouriteEventList();

        BrandEventAdapter favouriteEventAdapter = new BrandEventAdapter(favouriteEventList, FavouriteEventActivity.this);
        favouriteEventRecyclerView.setAdapter(favouriteEventAdapter);
        favouriteEventRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        

    }
}
