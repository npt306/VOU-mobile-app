package com.example.vou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    Button personalInfomationButton, friendButton, historyVoucherButton, myVoucherButton, eventButton;
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        personalInfomationButton = findViewById(R.id.profilePersonalInformation);
        friendButton = findViewById(R.id.profileFriend);
        historyVoucherButton = findViewById(R.id.profileVoucherHistory);
        myVoucherButton = findViewById(R.id.profileMyVoucher);
        eventButton = findViewById(R.id.profileEvent);
        backButton = findViewById(R.id.profileBackButton);

        personalInfomationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
