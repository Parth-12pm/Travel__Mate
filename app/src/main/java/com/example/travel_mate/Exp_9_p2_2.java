package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Exp_9_p2_2 extends AppCompatActivity {

    TextView Result;

    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exp9_p22);

        Result = findViewById(R.id.Result);
        b1 = findViewById(R.id.B1);

        Intent a = getIntent();

        String str =  a.getStringExtra("Addition");

        Result.setText(str);

        b1.setOnClickListener(v -> {
            Intent in = new Intent(Exp_9_p2_2.this, Exp_9_p2.class);
            startActivity(in);
        });
    }
}