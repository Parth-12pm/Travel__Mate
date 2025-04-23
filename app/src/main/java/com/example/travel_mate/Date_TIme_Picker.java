package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Date_TIme_Picker extends AppCompatActivity {

    DatePicker DP1;
    TimePicker TP1;
    TextView T1;
    Button B1;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_date_time_picker);

        DP1 = findViewById(R.id.DP1);
        TP1 = findViewById(R.id.TP1);
        T1 = findViewById(R.id.T1);
        B1 = findViewById(R.id.B1);


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = DP1.getDayOfMonth();
                int month = DP1.getMonth()+1;
                int year = DP1.getYear();

                int hr = TP1.getHour();
                int min = TP1.getMinute();

                T1.setText("Date :"+day+"/"+month+"/"+year+"\nTime :"+hr+":"+min);
            }
        });

    }

}