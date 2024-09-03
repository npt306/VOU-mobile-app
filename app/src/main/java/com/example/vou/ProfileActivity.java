package com.example.vou;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    Button personalInfomationButton, friendButton, historyVoucherButton, myVoucherButton, eventButton;
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



    }
}
