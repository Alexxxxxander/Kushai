package com.example.a23_kushai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class DBCHelper extends SQLiteOpenHelper  {
    private static final String DATABASE_NAME="kushai.db";
    private static final int SCHEMA = 1;

    //Таблица USERS
    static final String TABLE_USERS = "users";
    public static final String USERS_ID = "_id";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";

    public DBCHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" +USERS_ID
                +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ USERS_LOGIN
                + " TEXT, " + USERS_PASSWORD + " TEXT);");
        db.execSQL("INSERT INTO users (" + USERS_LOGIN +
                "," + USERS_PASSWORD +") VALUES('admin','admin');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
}
