package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exp5checkbox extends AppCompatActivity {

    CheckBox c1,c2,c3,c4,c5;
    Button B1;
    TextView T1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp5checkbox);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);

        T1 = findViewById(R.id.result);

        B1 = findViewById(R.id.B1);

        B1.setOnClickListener(v -> evaluateCheckboxes());

    }

    private void evaluateCheckboxes() {
        StringBuilder result = new StringBuilder("Selected Options:\n");

        if (c1.isChecked()) {
            result.append("Option 1\n");
        }
        if (c2.isChecked()) {
            result.append("Option 2\n");
        }
        if (c3.isChecked()) {
            result.append("Option 3\n");
        }
        if (c4.isChecked()) {
            result.append("Option 4\n");
        }
        if (c5.isChecked()) {
            result.append("Option 5\n");
        }

        // Display the result using a Toast message
        if (result.toString().equals("Selected Options:\n")) {
            Toast.makeText(this, "No options selected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show();
            T1.setText(result);
        }
    }

}