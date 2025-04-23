package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Auto_Complete_TextView extends AppCompatActivity {

    AutoCompleteTextView AC1;
    String Fruit[] = {"Mango","Kiwi","Guava","Apple","PineApple"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        AC1 = findViewById(R.id.AC1);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item,Fruit);
        AC1.setThreshold(2);
        AC1.setAdapter(adapter);
    }
}