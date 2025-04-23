package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Animation extends AppCompatActivity {

    ImageView I1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animation);

        I1 = findViewById(R.id.I1);
    }

    public void rotate (View view){
        Animation obj = AnimationUtils.loadAnimation(this, R.anim.rotate);
        I1.startAnimation(obj);
    }
}