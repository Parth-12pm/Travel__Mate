package com.example.travel_mate;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Database extends AppCompatActivity
{
    Button ins,del,upd,view;
    db_helper db;
    EditText name, marks, delData;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        ins = findViewById(R.id.ins);
        view = findViewById(R.id.view);
        del = findViewById(R.id.del);
        upd = findViewById(R.id.upd);
        name = findViewById(R.id.name);
        marks = findViewById(R.id.marks);
        marks = findViewById(R.id.delData);
        db = new db_helper(this);

        ins.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String n = name.getText().toString();
                String m = marks.getText().toString();
                Boolean res =db.insertData(n, m);
                if(res == true)
                {
                    Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Record Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = db.deleteData(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(Database.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Database.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                db.updateData();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Cursor c = db.displayData();
                if(c == null)
                {
                    Toast.makeText(getApplicationContext(), "No Records Exist.", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer = new StringBuffer();
                while(c.moveToNext()) {
                    buffer.append("Name: " + c.getString(0) + " ");
                    buffer.append("Marks: " + c.getString(1) + " \n");
                    AlertDialog dialog = new AlertDialog.Builder(Database.this).create();
                    dialog.setTitle("Student Record");
                    dialog.setMessage(buffer.toString());
                    dialog.show();
                }

            }
        });

    }
}