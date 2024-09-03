package com.example.vou;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ClipboardManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vou.Model.Voucher;

public class VoucherDetailActivity extends AppCompatActivity {
    TextView voucherDetailSale, voucherDetailDescription, voucherDetailExpiredDate, voucherDetailCode;
    Button voucherDetailQR, voucherDetailGive;
    ImageView voucherDetailBackButton, voucherDetailCopy;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_voucher_details);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.voucher_detail_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Voucher voucher = (Voucher) getIntent().getSerializableExtra("voucher");

        context = this;

        voucherDetailSale = findViewById(R.id.voucherDetailSale);
        voucherDetailDescription = findViewById(R.id.voucherDetailDescription);
        voucherDetailExpiredDate = findViewById(R.id.voucherDetailExpiredDay);
        voucherDetailCode = findViewById(R.id.voucherDetailCode);

        voucherDetailQR = findViewById(R.id.voucherDetailQR);
        voucherDetailGive = findViewById(R.id.voucherDetailGift);

        voucherDetailCopy = findViewById(R.id.voucherDetailCopy);
        voucherDetailBackButton = findViewById(R.id.voucherDetailBackButton);

        if (voucher != null) {
            voucherDetailSale.setText(voucher.getSale());
            voucherDetailDescription.setText(voucher.getDescription());
            voucherDetailExpiredDate.setText(voucher.getExpiredDayString());
            voucherDetailCode.setText(voucher.getCode());
        }

        voucherDetailBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        voucherDetailCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = voucherDetailCode.getText().toString();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("VOU code copy", text);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context, "Copied in clipboard", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

