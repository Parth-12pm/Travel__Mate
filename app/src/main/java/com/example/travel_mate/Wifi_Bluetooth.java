package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Wifi_Bluetooth extends AppCompatActivity {

    Button B1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wifi_bluetooth);

        B1 = findViewById(R.id.B1);


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1 = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    startActivity(I1);
                    Toast.makeText(Wifi_Bluetooth.this, "Go to settings to enable Wi-Fi", Toast.LENGTH_LONG).show();
                }

        });



    }
}