package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Text_To_Speech extends AppCompatActivity {

    EditText E1;
    Button B1;

    TextToSpeech obj;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_text_to_speech);

        E1 = findViewById(R.id.E1);
        B1 = findViewById(R.id.B1);

        obj = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                obj.setLanguage(Locale.ENGLISH);
            }
        });

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = E1.getText().toString();
                obj.speak(str, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}