package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class Listview extends AppCompatActivity {

    TextView text;
    ListView list;
    String cities[] = {
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "London", "Paris", "Tokyo", "Berlin", "Toronto",
            "Sydney", "Dubai", "Mumbai", "Singapore", "Barcelona",
            "Hong Kong", "Rome", "Bangkok", "Istanbul", "Amsterdam"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listview2);

        text = findViewById(R.id.text1);
        list = findViewById(R.id.L1);

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.textview,R.id.text1,cities);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = cities[position];
                Toast.makeText(Listview.this, "Selected City: " + selectedCity, Toast.LENGTH_SHORT).show();
            }
        });

    }


}