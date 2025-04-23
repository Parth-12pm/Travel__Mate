package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Wifi_2 extends AppCompatActivity {

    Button B1,B2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wifi2);

        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);


        WifiManager  wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiManager.setWifiEnabled(true);
                Toast.makeText(Wifi_2.this, "Wi-Fi Enabled", Toast.LENGTH_SHORT).show();            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiManager.setWifiEnabled(false);
                Toast.makeText(Wifi_2.this, "Wi-Fi Disabled", Toast.LENGTH_SHORT).show();            }
        });

    }
}