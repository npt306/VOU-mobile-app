package com.example.vou;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vou.Model.Event;
import com.example.vou.Model.Voucher;

public class EventDetailActivity extends AppCompatActivity {
    ImageView backButton, eventImage;
    TextView eventName, eventStartDate, eventEndDate, evenDescription;
    Button eventPlayNow;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.event_detail_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Event event = (Event) getIntent().getSerializableExtra("event_detail");

        context = this;

        backButton = findViewById(R.id.event_detail_back_button);
        eventImage = findViewById(R.id.event_detail_image);
        eventName = findViewById(R.id.event_detail_name);
        eventStartDate = findViewById(R.id.event_detail_start_date);
        eventEndDate = findViewById(R.id.event_detail_end_date);
        evenDescription = findViewById(R.id.event_detail_description);
        eventPlayNow = findViewById(R.id.event_detail_play_now_button);

        eventImage.setImageResource(event.getImage());
        eventName.setText(event.getName());
        eventStartDate.setText(event.getStart_date2());
        eventEndDate.setText(event.getEnd_date2());
        evenDescription.setText(event.getGuideline());

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        eventPlayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
