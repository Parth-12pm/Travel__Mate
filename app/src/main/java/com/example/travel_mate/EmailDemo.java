package com.example.travel_mate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EmailDemo extends AppCompatActivity {
    EditText emailAdd,subject,body;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emaildemo);

        emailAdd = findViewById(R.id.e1);
        subject = findViewById(R.id.e2);
        body = findViewById(R.id.e3);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(view -> {
            String email = emailAdd.getText().toString();
            String sub = subject.getText().toString();
            String bd = body.getText().toString();

            Intent in = new Intent(Intent.ACTION_SEND);
            in.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
            in.putExtra(Intent.EXTRA_SUBJECT,sub);
            in.putExtra(Intent.EXTRA_TEXT,bd);
            in.setType("message/rfc822");
            startActivity(Intent.createChooser(in,"Choose"));
        });
    }
}