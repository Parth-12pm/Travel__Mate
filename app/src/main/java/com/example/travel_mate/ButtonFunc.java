package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Button extends AppCompatActivity {
    RadioButton R1,R2;
    ToggleButton T1;
    TextView Result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        R1 = findViewById(R.id.R1);
        R2 = findViewById(R.id.R2);
        T1 = findViewById(R.id.T1);
        Result = findViewById(R.id.Result);

        R1.setOnClickListener(v -> evaluate());
        R2.setOnClickListener(v -> evaluate());
        T1.setOnClickListener(v -> evaluateToggle());
    }

    private  void evaluateToggle(){
        if(T1.isChecked()){
            Toast.makeText(this,"Status : ON",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this , "Status : OFF", Toast.LENGTH_LONG).show();
        }
    }

    private  void evaluate() {
        String str = "None" ;

        if(R1.isChecked()){
            str = "Male";
        }
        if(R2.isChecked()){
            str = "Female";
        }

        Result.setText("Selected : "+ str);
        Toast.makeText(this,"Selected :" + str , Toast.LENGTH_LONG).show();

   }
}