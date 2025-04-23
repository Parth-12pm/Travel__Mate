package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class Music_controller_Player extends AppCompatActivity {

    Button b1,b2,b3,b4,b5 ;
    VideoView v1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_music_controller_player);

        b1 = findViewById(R.id.B1);
        b2 = findViewById(R.id.B2);
        b3 = findViewById(R.id.B3);
        b4 = findViewById(R.id.B4);
        b5 = findViewById(R.id.B5);
        v1 = findViewById(R.id.v1);

        MediaPlayer m1 = MediaPlayer.create(this,R.raw.music1);
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video1);

        MediaController mc = new MediaController(this);
        v1.setMediaController(mc);
        v1.start();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.start();
            }
        });;


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.pause();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    m1.stop();
                    m1.prepare();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}