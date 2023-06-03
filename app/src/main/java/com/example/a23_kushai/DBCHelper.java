package com.example.a23_kushai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class DBCHelper extends SQLiteOpenHelper  {
    private static final String DATABASE_NAME="kushai.db";
    private static final int SCHEMA = 3;

    //Таблица USERS
    static final String TABLE_USERS = "users";
    public static final String USERS_ID = "_id";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";

    //Таблица RESTRAUNT
    static final String TABLE_RESTR = "restraunts";
    public static final String RESTR_ID = "_id";
    public static final String RESTR_NAME= "title";
    public static final String RESTR_CATEGORIES = "categories";
    public static final String RESTR_RATE = "rate";
    public static final String RESTR_IMAGE = "mainImage";
    public static final String RESTR_TIME_MIN = "timeMin";
    public static final String RESTR_TIME_MAX = "timeMax";

    public DBCHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Созданние таблицы пользователей
        db.execSQL("CREATE TABLE users ("
                + USERS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + USERS_LOGIN + " TEXT UNIQUE, "
                + USERS_PASSWORD + " TEXT);");
        //Добавление пользователя админа
        db.execSQL("INSERT INTO users (" + USERS_LOGIN +
                "," + USERS_PASSWORD +") VALUES('admin','admin');");
        //Создание таблицы ресторанов
        db.execSQL("CREATE TABLE " +TABLE_RESTR + "("
                + RESTR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + RESTR_NAME + " TEXT UNIQUE, "
                + RESTR_RATE + " REAL, "
                + RESTR_CATEGORIES + " TEXT, "
                + RESTR_IMAGE + " INTEGER,"
                + RESTR_TIME_MIN + "INTEGER,"
                + RESTR_TIME_MAX + "INTEGER);");
        //Добавление первого ресторана
        db.execSQL("INSERT INTO " + TABLE_RESTR +
                "(" + RESTR_NAME + ", "
                + RESTR_RATE + ", "
                + RESTR_CATEGORIES + ", "
                + RESTR_IMAGE + ", "
                + RESTR_TIME_MIN + ", "
                + RESTR_TIME_MAX + ") "
                + "VALUES('Pizza Hunter', 4.4, 'Пицца, Суши' , " + R.drawable.pizzammmmrestr +","+"20" + ","+"30" + ");");
        db.execSQL("INSERT INTO " + TABLE_RESTR +
                "(" + RESTR_NAME + ", "
                + RESTR_RATE + ", "
                + RESTR_CATEGORIES + ", "
                + RESTR_IMAGE + ", "
                + RESTR_TIME_MIN + ", "
                + RESTR_TIME_MAX + ") "
                + "VALUES('Кофейня у дома', 4.3, 'Кофе' , " + R.drawable.cofeya +","+"10" + ","+"25" + ");");
        db.execSQL("INSERT INTO " + TABLE_RESTR +
                "(" + RESTR_NAME + ", "
                + RESTR_RATE + ", "
                + RESTR_CATEGORIES + ", "
                + RESTR_IMAGE + ", "
                + RESTR_TIME_MIN + ", "
                + RESTR_TIME_MAX + ") "
                + "VALUES('Pizza Hunter', 4.4, 'Пицца, Бургеры' , " + R.drawable.glavpizz +","+"20" + ","+"30" + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTR);
        onCreate(db);
    }
}
