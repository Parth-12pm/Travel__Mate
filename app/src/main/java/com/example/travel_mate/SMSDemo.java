package com.example.travel_mate;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.Manifest;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SMSDemo extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_smsdemo);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.b1);


        b1.setOnClickListener(view -> {
            if (checkPermission()) {
                sendSms();
            } else {
                requestPermission();
            }
        });
    }

    private boolean checkPermission()
    {
        int res = ContextCompat.checkSelfPermission(SMSDemo.this, Manifest.permission.SEND_SMS);
        return res == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission()
    {
        ActivityCompat.requestPermissions(SMSDemo.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_CODE);
    }

    public void sendSms()
    {
        String phone = e1.getText().toString();
        e1.setText("");
        String msg = e2.getText().toString();
        e2.setText("");

        try {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(phone, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Message Not Sent", Toast.LENGTH_SHORT).show();
        }
    }
}

