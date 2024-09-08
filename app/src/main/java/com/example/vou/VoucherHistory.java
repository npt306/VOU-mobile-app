package com.example.vou;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Adapter.HistoryVoucherAdapter;
import com.example.vou.Adapter.MyVoucherAdapter;
import com.example.vou.Singleton.VoucherSingleton;

public class VoucherHistory extends AppCompatActivity {
    ImageView backButton;
    RecyclerView historyVoucherRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_voucher_history);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.voucher_history_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backButton = findViewById(R.id.voucher_history_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        historyVoucherRecyclerView = findViewById(R.id.recyclerViewVoucherHistory);
        HistoryVoucherAdapter historyVoucherAdapter = new HistoryVoucherAdapter(VoucherSingleton.getInstance().getHistoryVoucherList(), this);
        historyVoucherRecyclerView.setAdapter(historyVoucherAdapter);
        historyVoucherRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
