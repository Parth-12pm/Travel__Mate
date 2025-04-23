package com.example.travel_mate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class db_helper extends SQLiteOpenHelper
{

    public db_helper(@Nullable Context context)
    {
        super(context, "college", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table student(name varchar(20),marks varchar(3))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public boolean insertData(String n, String m)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", n);
        cv.put("marks", m);
        Long res = db.insert("student", null, cv);
        if(res != -1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public Cursor displayData()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select * from student", null);
        return c;
    }

    public boolean deleteData(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from student where name = ?", new String[]{name});
        if (cursor.getCount() > 0)
        {
            long result = db.delete("student", "name=?", new String[]{name});
            if (result == -1)
            {
                return false;
            } else
            {
                return true;
            }
        } else
        {
            return false;
        }
    }







}