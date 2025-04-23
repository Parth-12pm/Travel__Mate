package com.example.travel_mate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class GridViewExp extends AppCompatActivity {

    GridView gridView;
    String[] cities = {"New York", "London", "Tokyo", "Mumbai", "Paris", "Sydney", "Berlin", "Dubai", "Toronto", "Singapore"};



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_exp);

        gridView = findViewById(R.id.gridView);

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.textview,R.id.text1,cities);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener((adapterView, view, position, id) -> {
            String selectedCity = cities[position];
            Toast.makeText(this, "Selected: " + selectedCity, Toast.LENGTH_SHORT).show();
        });


    }
}