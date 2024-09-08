package com.example.vou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vou.Model.Event;
import com.example.vou.Model.Voucher;
import com.example.vou.Singleton.EventSingleton;

public class GameShakePhoneActivity extends AppCompatActivity implements SensorEventListener {
    Context context;
    ImageView backButton, eventDetail, eventImage;
    TextView numberOfTurn;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private static final int SHAKE_THRESHOLD = 800;
    private long lastUpdate = 0;
    private float lastX, lastY, lastZ;
    Event voucherEvent;
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

        voucherEvent = (Event) getIntent().getSerializableExtra("event_data");
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
        int numOfTurn = EventSingleton.getInstance().getNumberOfTurn(voucherEvent.getId());
        numberOfTurn.setText("You have " + numOfTurn + " plays left for this event");

        eventImage.setImageResource(voucherEvent.getImage());

        eventDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailActivity.class);
                intent.putExtra("event_detail", voucherEvent);
                context.startActivity(intent);
            }
        });

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (accelerometer != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        long curTime = System.currentTimeMillis();
        if ((curTime - lastUpdate) > 100) {
            long diffTime = (curTime - lastUpdate);
            lastUpdate = curTime;

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float speed = Math.abs(x + y + z - lastX - lastY - lastZ) / diffTime * 10000;

            if (speed > SHAKE_THRESHOLD) {
                Intent intent = new Intent(context, GameResultActivity.class);
                intent.putExtra("event_result", voucherEvent);
                context.startActivity(intent);
            }

            lastX = x;
            lastY = y;
            lastZ = z;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
