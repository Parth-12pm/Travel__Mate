package com.example.travel_mate;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Life_Cycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifeCycle","Activity Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","Activity Started");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","Activity Restarted");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","Activity Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","Activity Destroyed");
    }
}