package com.abhilasha.androidclass.student_registration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME="database_one";
    public static final int DATABASE_VERSION=3;
    public static final String CREATE_TABLE= "CREATE TABLE user_login(firstname text,middlename text,lastname text,email text,phnumber text,day_id text,month_id text,year_id text,spin_ethnicity text,gender_id,studentid text,entryid text,grade_id text,spin_semester text )";



    public DbHelper(@Nullable MainActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
