package com.example.vou;

import android.content.Context;
import android.content.Intent;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Adapter.FriendAdapter;
import com.example.vou.Adapter.GameResultAdapter;
import com.example.vou.Model.Event;
import com.example.vou.Model.User;
import com.example.vou.Singleton.EventSingleton;
import com.example.vou.Singleton.UserSingleton;
import com.example.vou.Singleton.VoucherSingleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameResultActivity extends AppCompatActivity {
    Context context;
    ImageView backButton;
    TextView numberOfTurn;
    Button playAgainButton;
    RecyclerView voucherResultRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_result);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.game_result_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Event event = (Event) getIntent().getSerializableExtra("event_result");
        context = this;

        backButton = findViewById(R.id.game_result_back_button);
        numberOfTurn = findViewById(R.id.game_result_number_of_turn);
        playAgainButton = findViewById(R.id.game_result_play_again_button);
        voucherResultRecyclerView = findViewById(R.id.game_result_recycler_view_voucher);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        assert event != null;
        List<Integer> voucherResult = randomSelectVouchers(event.getVoucherIdList());
        for(int i = 0; i < voucherResult.size(); i++){
            VoucherSingleton.getInstance().addVoucherFromGame(voucherResult.get(i));
        }
        int numOfTurn = EventSingleton.getInstance().getNumberOfTurn(event.getId());
        EventSingleton.getInstance().updateNumberOfTurn(event.getId(), numOfTurn - 1);

        GameResultAdapter gameResultAdapter = new GameResultAdapter(voucherResult);
        voucherResultRecyclerView.setAdapter(gameResultAdapter);
        voucherResultRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        numberOfTurn.setText("You have " + EventSingleton.getInstance().getNumberOfTurn(event.getId()) + " plays left for this event");
    }


    public List<Integer> randomSelectVouchers(List<Integer> voucherIdList) {
        Random random = new Random();
        List<Integer> voucherResult = new ArrayList<>();

        int[] numOfVoucherProbabilities = {20, 50, 20, 10};
        int numOfVouchers = randomWithProbability(numOfVoucherProbabilities, random);

        if (numOfVouchers == 0) {
            return voucherResult;
        }

        Collections.shuffle(voucherIdList, random);

        for (int i = 0; i < numOfVouchers && i < voucherIdList.size(); i++) {
            voucherResult.add(voucherIdList.get(i));
        }

        return voucherResult;
    }

    private int randomWithProbability(int[] probabilities, Random random) {
        int sum = 0;
        for (int probability : probabilities) {
            sum += probability;
        }
        int randomValue = random.nextInt(sum); // Random số từ 0 đến tổng của xác suất
        int accumulatedProbability = 0;

        for (int i = 0; i < probabilities.length; i++) {
            accumulatedProbability += probabilities[i];
            if (randomValue < accumulatedProbability) {
                return i;
            }
        }
        return 0;
    }
}
