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
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Model.Brand;
import com.example.vou.Model.Voucher;

public class BrandEventActivity extends AppCompatActivity {
    private Context context;
    private ImageView brandEventBackButton;
    private TextView brandEventTitle;
    private ToggleButton toggleNew, toggleHot, toggleGood;
    private RecyclerView brandEventRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_brand_event);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.brand_event_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Brand brand = (Brand) getIntent().getSerializableExtra("brand");

        context = this;

        brandEventBackButton = findViewById(R.id.brand_event_back_button);
        brandEventTitle = findViewById(R.id.brand_event_title);
        toggleNew = findViewById(R.id.brandEvenToggleNew);
        toggleHot = findViewById(R.id.brandEventToggleHot);
        toggleGood = findViewById(R.id.brandEventToggleGood);
        brandEventRecyclerView = findViewById(R.id.recyclerViewBrandEvent);

        brandEventBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        brandEventTitle.setText(brand.getName());


    }
}
