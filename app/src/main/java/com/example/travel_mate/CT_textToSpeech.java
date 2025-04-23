package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class CT_textToSpeech extends AppCompatActivity {
    EditText E1;
    Button B1;
    TextToSpeech T1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ct_text_to_speech);

        E1 = findViewById(R.id.E1);
        B1 = findViewById(R.id.B1);

        T1 = new TextToSpeech(this , status ->{
            if(status == TextToSpeech.SUCCESS){
                T1.setLanguage(Locale.ENGLISH);
            }
        });

        B1.setOnClickListener(v -> {
            String str = E1.getText().toString();
            T1.speak(str , TextToSpeech.QUEUE_FLUSH, null , null );
        });
    }
}