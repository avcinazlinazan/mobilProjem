package com.example.kelimedata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class veritabani extends SQLiteOpenHelper {
    private static final String TABLE_NAME="Kelimeler"; //Tablo1 Adı
    private static final String TABLE_NAME2="Cumleler"; //Tablo2 Adı
    private static final String TABLE_NAME3="Sorular";
    private static final String DATABASE_NAME="SozlukDB";  //Veritabanı Adı
    private static final int DATABASE_VERSION=1;
    private static final String KELIME_TURKCE="turkce";
    private static final String KELIME_FRANSIZCA="fransizca";
    private static final String KELIME_TURU="turu";
    private static final String KELIME_CINSIYETI="cinsiyeti";
    private static final String KELIME_RESMI="resmi";


    private static final String CUMLE_TURKCE="cumle_turkce";
    private static final String CUMLE_FRANSIZCA="cumle_fransizca";
    private static final String CUMLE_RESMI="cumle_resmi";

    private static final String SORU_TURKCE="soru_turkce";
    private static final String SORU_FRANSIZCA="soru_fransizca";
    private static final String SORU_RESMI="soru_resmi";


    public veritabani( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS  "+TABLE_NAME2+" (cumle_id INTEGER PRIMARY KEY AUTOINCREMENT,"+CUMLE_TURKCE+" TEXT,"+CUMLE_FRANSIZCA+" TEXT,"+CUMLE_RESMI+" TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS  "+TABLE_NAME3+" (soru_id INTEGER PRIMARY KEY AUTOINCREMENT,"+SORU_TURKCE+" TEXT,"+SORU_FRANSIZCA+" TEXT,"+SORU_RESMI+" TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS  "+TABLE_NAME+" " +
                "(kelime_id INTEGER PRIMARY KEY AUTOINCREMENT,cumle_id INTEGER,soru_id INTERGER, " +
                ""+KELIME_TURKCE+" TEXT,"+KELIME_FRANSIZCA+" TEXT,"+KELIME_TURU+" TEXT,"+KELIME_CINSIYETI+" TEXT," +
                ""+KELIME_RESMI+" TEXT, FOREIGN KEY (cumle_id) REFERENCES Cumleler (cumle_id),FOREIGN KEY (soru_id) REFERENCES Sorular (soru_id) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE If EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE If EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE If EXISTS "+TABLE_NAME2);
        this.onCreate(db);//onCreate fonksiyonu çağrılarak oluşturduğumuz veritabanı tablosunda güncelleme yaptık.
    }
}
