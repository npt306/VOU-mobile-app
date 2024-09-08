package com.example.vou;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Adapter.FriendAdapter;
import com.example.vou.Model.User;
import com.example.vou.Singleton.UserSingleton;

import java.util.List;

public class FriendActivity extends AppCompatActivity {
    ImageView backButton;
    RecyclerView friendRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friend);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.friend_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backButton = findViewById(R.id.friend_back_button);
        friendRecyclerView = findViewById(R.id.recyclerViewFriend);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        List<User> userList = UserSingleton.getInstance().getUserList();

        FriendAdapter friendAdapter = new FriendAdapter(userList, FriendActivity.this);
        friendRecyclerView.setAdapter(friendAdapter);
        friendRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
