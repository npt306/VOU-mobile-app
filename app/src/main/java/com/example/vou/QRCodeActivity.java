package com.example.vou;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vou.Model.Voucher;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRCodeActivity extends AppCompatActivity {
    TextView QRCodeVoucherName, QRCodeVoucherSale, QRCodeVoucherExpiredDate, QRCodeVoucherDescription;
    ImageView QRCodeBackButton, QRCodeImage;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qr_code);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.qr_code_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        QRCodeVoucherName = findViewById(R.id.QRCodeVoucherName);
        QRCodeVoucherSale = findViewById(R.id.QRCodeVoucherSale);
        QRCodeVoucherExpiredDate = findViewById(R.id.QRCodeExpiredDay);
        QRCodeVoucherDescription = findViewById(R.id.QRCodeDescription);

        QRCodeBackButton = findViewById(R.id.qrCodeBackButton);
        QRCodeImage = findViewById(R.id.QRCode);

        context = this;

        Voucher voucher = (Voucher) getIntent().getSerializableExtra("voucher");

        if(voucher != null){
            QRCodeVoucherName.setText(voucher.getName());
            QRCodeVoucherSale.setText(voucher.getSale());
            QRCodeVoucherExpiredDate.setText(voucher.getExpiredDayString());
            QRCodeVoucherDescription.setText(voucher.getDescription());

            try {
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.encodeBitmap(voucher.getCode(), BarcodeFormat.QR_CODE, 300, 300);
                QRCodeImage.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }

        QRCodeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
