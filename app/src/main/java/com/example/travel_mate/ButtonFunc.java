package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ButtonFunc extends AppCompatActivity {
    RadioButton R1,R2;
    RadioGroup radioGroup;
    ToggleButton T1;
    TextView Result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);


        radioGroup = findViewById(R.id.radioGroup);
        R1 = findViewById(R.id.R1);
        R2 = findViewById(R.id.R2);
        T1 = findViewById(R.id.T1);
        Result = findViewById(R.id.Result);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> evaluate());
        T1.setOnClickListener(v -> evaluateToggle());

    }

    private void evaluateToggle() {
        String message = T1.isChecked() ? "Status : ON" : "Status : OFF";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void evaluate() {
        int checkedId = radioGroup.getCheckedRadioButtonId();
        String str = "None";

        if (checkedId == R.id.R1) {
            str = "Male";
        } else if (checkedId == R.id.R2) {
            str = "Female";
        }
        Result.setText("Selected: " + str);
        Toast.makeText(this, "Selected: " + str, Toast.LENGTH_SHORT).show();
    }
}