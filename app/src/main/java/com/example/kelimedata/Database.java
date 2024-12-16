package com.example.kelimedata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context,"kelimeDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS  Cumleler (cumle_id INTEGER PRIMARY KEY AUTOINCREMENT,cumle_turkce TEXT,cumle_fransizca TEXT,cumle_resmi TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS  Sorular (soru_id INTEGER PRIMARY KEY AUTOINCREMENT,soru_turkce TEXT,soru_fransizca TEXT,soru_resmi TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS  Kelimeler (kelime_id INTEGER PRIMARY KEY AUTOINCREMENT,kelime_turkce TEXT,kelime_fransizca TEXT,kelime_turu TEXT," +
                "kelime_cinsiyeti TEXT,  kelime_resmi TEXT,cumle_id INTEGER,soru_id INTERGER, FOREIGN KEY (cumle_id) REFERENCES Cumleler (cumle_id)," +
                "FOREIGN KEY (soru_id) REFERENCES Sorular (soru_id) )");
        db.execSQL("CREATE TABLE IF NOT EXISTS  Quizler (quiz_id INTEGER PRIMARY KEY AUTOINCREMENT,turkce TEXT,fransizca TEXT,resmi TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE If EXISTS  Kelimeler");
        db.execSQL("DROP TABLE If EXISTS Cumleler");
        db.execSQL("DROP TABLE If EXISTS Sorular");
        db.execSQL("DROP TABLE If EXISTS Quizler");
        this.onCreate(db);//onCreate fonksiyonu çağrılarak oluşturduğumuz veritabanı tablosunda güncelleme yaptık.
    }


}
