package com.example.travel_mate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText E1,E2;
    Button Btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        E1 = findViewById(R.id.LinearE1);
        E2 = findViewById(R.id.LinearE2);
        Btn1 = findViewById(R.id.login1);

        Btn1.setOnClickListener(v -> onbtnclick());
    }

    public void onbtnclick(){
        String username = E1.getText().toString();
        String password = E2.getText().toString();

        Toast.makeText(this, "Username: " + username + "\nPassword: " + password, Toast.LENGTH_LONG).show();
    }

}