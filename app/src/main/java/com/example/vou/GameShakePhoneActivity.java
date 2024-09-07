package com.example.vou;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vou.Model.Event;
import com.example.vou.Model.Voucher;

public class GameShakePhoneActivity extends AppCompatActivity {
    Context context;
    ImageView backButton, eventDetail, eventImage;
    TextView numberOfTurn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_shake_phone);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.shake_phone_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Event event = (Event) getIntent().getSerializableExtra("event_data");
        context = this;

        backButton = findViewById(R.id.shake_phone_back_button);
        eventDetail = findViewById(R.id.shake_phone_event_information);
        eventImage = findViewById(R.id.shake_phone_image);
        numberOfTurn = findViewById(R.id.shake_phone_number_of_turn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        numberOfTurn.setText("You have " + event.getNum_of_turn() + " plays left for this event");

        eventImage.setImageResource(event.getImage());

        eventDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailActivity.class);
                intent.putExtra("event_detail", event);
                context.startActivity(intent);
            }
        });
    }
}
