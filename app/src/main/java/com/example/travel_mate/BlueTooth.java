package com.example.travel_mate;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Set;

public class BlueTooth extends AppCompatActivity {
    TextView tv;
    Button on, off, list;
    BluetoothAdapter mBluetoothAdapter;
    private static final int REQUEST_BLUETOOTH_PERMISSION = 1;
    private static final int REQUEST_ENABLE_BT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth);

        on = findViewById(R.id.on);
        off = findViewById(R.id.off);
        list = findViewById(R.id.list);
        tv = findViewById(R.id.res);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        // Request Bluetooth permission at startup
        if (!checkPermission()) {
            requestBluetoothPermission();
        }

        // Turn ON Bluetooth
        on.setOnClickListener(v -> {
            if (!mBluetoothAdapter.isEnabled()) {
                if (checkPermission()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                }
            } else {
                Toast.makeText(BlueTooth.this, "Bluetooth is already ON", Toast.LENGTH_SHORT).show();
            }
        });

        // Turn OFF Bluetooth
        off.setOnClickListener(v -> {
            if (mBluetoothAdapter.isEnabled()) {
                Intent intent = new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent);
                Toast.makeText(BlueTooth.this, "Go to settings to turn off Bluetooth", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(BlueTooth.this, "Bluetooth is already OFF", Toast.LENGTH_SHORT).show();
            }
        });

        // List paired Bluetooth devices
        list.setOnClickListener(v -> {
            if (!checkPermission()) {
                requestBluetoothPermission();
                return;
            }

            Set<BluetoothDevice> devices = mBluetoothAdapter.getBondedDevices();
            tv.setText(""); // Clear previous results

            if (devices.size() > 0) {
                for (BluetoothDevice device : devices) {
                    tv.append("\n\nDevice: " + device.getName() + " - " + device.getAddress());
                }
            } else {
                tv.setText("No paired Bluetooth devices found.");
            }
        });
    }

    // Check Bluetooth permission
    public boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED;
    }

    // Request Bluetooth permission if not granted
    public void requestBluetoothPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.BLUETOOTH_CONNECT}, REQUEST_BLUETOOTH_PERMISSION);
    }

    // Handle permission request result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_BLUETOOTH_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Bluetooth permission granted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth permission denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Handle Bluetooth enable request result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Bluetooth enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth enabling canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}