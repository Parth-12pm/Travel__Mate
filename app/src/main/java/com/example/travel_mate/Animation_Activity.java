package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Animation_Activity extends AppCompatActivity {

    ImageView I1;
    Button B1,B2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animation);

        I1 = findViewById(R.id.I1);
        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);

        B1.setOnClickListener(v ->{rotate(I1);});
        B2.setOnClickListener(v->{zoom(I1);});

    }
    public void rotate(View view) {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        I1.startAnimation(rotateAnimation);
    }

    public void zoom(View view) {
        Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        I1.startAnimation(zoomAnimation);
    }
}

