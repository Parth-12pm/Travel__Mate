package com.example.travel_mate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Artihmetic extends AppCompatActivity {

    TextView Result;
    EditText Num1, Num2;
    Button btnAdd, btnSub, btnMulti, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_artihmetic);

        Num1 = findViewById(R.id.E1);
        Num2 = findViewById(R.id.E2);
        Result = findViewById(R.id.Result);
        btnAdd = findViewById(R.id.B1);
        btnSub = findViewById(R.id.b2);
        btnMulti = findViewById(R.id.b3);
        btnDiv = findViewById(R.id.b4);

        btnAdd.setOnClickListener(v -> performOperation("add"));
        btnSub.setOnClickListener(v -> performOperation("sub"));
        btnMulti.setOnClickListener(v -> performOperation("multi"));
        btnDiv.setOnClickListener(v -> performOperation("div"));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.arithmetic_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    private void performOperation(String operation) {
        try {
            // Get input numbers
            double num1 = Double.parseDouble(Num1.getText().toString());
            double num2 = Double.parseDouble(Num2.getText().toString());
            double result;

            // Perform the operation
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "sub":
                    result = num1 - num2;
                    break;
                case "multi":
                    result = num1 * num2;
                    break;
                case "div":
                    if (num2 == 0) {
                        Toast.makeText(this, "Division by zero is not allowed", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation");
            }

            // Display the result
            Result.setText("Result: " + result);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

}