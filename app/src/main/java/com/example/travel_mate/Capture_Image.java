package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Capture_Image extends AppCompatActivity {

    ImageView I1;
    VideoView V1;
    Button B1,B2;
    int REQ_CODE = 10;
    int REQ_CODE_V = 20;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_capture_image);

        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);
        I1 = findViewById(R.id.I1);
        V1 = findViewById(R.id.V1);

        B1.setOnClickListener(v -> {
            Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(in, REQ_CODE);
        });

        B2.setOnClickListener(v -> {
            Intent in = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(in, REQ_CODE_V);
        });
    }

        protected void onActivityResult(int reqcode , int resultCode , Intent  data){
            super.onActivityResult(reqcode,resultCode,data);
            if(reqcode == REQ_CODE){
                Bitmap image = (Bitmap) data.getExtras().get("data");
                I1.setImageBitmap(image);
            }
            if(reqcode == REQ_CODE_V){
                MediaController mc = new MediaController(this);
                V1.setMediaController(mc);
                Uri videoUri = data.getData();
                V1.setVideoURI(videoUri);
                V1.start();
            }
        }   


}