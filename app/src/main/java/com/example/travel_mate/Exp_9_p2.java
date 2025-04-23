package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exp_9_p2 extends AppCompatActivity {

    TextView Result;
    EditText Num1, Num2;
    Button btnAdd;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exp9_p2);

        Num1 = findViewById(R.id.E1);
        Num2 = findViewById(R.id.E2);
        Result = findViewById(R.id.Result);
        btnAdd = findViewById(R.id.B1);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(Num1.getText().toString());
                int n2 = Integer.parseInt(Num2.getText().toString());
                int result = n1+n2;

                String str = String.valueOf(result);

                Intent in = new Intent(Exp_9_p2.this, Exp_9_p2_2.class);
                in.putExtra("Addition",str);
                startActivity(in);
            }
        });

    }

}