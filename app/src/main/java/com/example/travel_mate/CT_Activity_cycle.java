package com.example.travel_mate;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CT_Activity_cycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ct_cycle);
        showToast("Activity Created");
    }

    public void onStart(){
        super.onStart();
        showToast("Activity started");
    }

    public void onResume(){
        super.onResume();
        showToast("Activity resumed");
    }

    public void onPause(){
        super.onPause();
        showToast("Activity paused");
    }

    public void onStop(){
        super.onStop();
        showToast("Activity stopped");
    }

    public void onDestroy(){
        super.onDestroy();
        showToast("Activity destroyed");
    }

    public void onRestart(){
        super.onRestart();
        showToast("Activity Restarted");
    }

    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}