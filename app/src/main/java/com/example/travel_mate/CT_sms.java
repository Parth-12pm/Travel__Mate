package com.example.travel_mate;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CT_sms extends AppCompatActivity {

    EditText E1,E2;
    Button B1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ct_sms);

        E1 = findViewById(R.id.E1);
        E2 = findViewById(R.id.E2);
        B1 = findViewById(R.id.B1);


        ActivityCompat.requestPermissions(this , new String[]{android.Manifest.permission.SEND_SMS}, 1);

        B1.setOnClickListener(v -> {
                String phone = E1.getText().toString();
                String msg = E2.getText().toString();

                if(ActivityCompat.checkSelfPermission(this , android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phone,null,msg,null,null);
                    Toast.makeText(this,"sms sent", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"sms not sent", Toast.LENGTH_LONG).show();

                }
        });

    }
}