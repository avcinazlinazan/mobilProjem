package com.example.kelimedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class KelimelerDao {
    public ArrayList<Kelimeler> tumKelimeler(Database vt,int kelime_id) {
        ArrayList<Kelimeler> KelimelerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Kelimeler,Cumleler,Sorular WHERE Kelimeler.cumle_id=Cumleler.cumle_id and Kelimeler.soru_id=Sorular.soru_id and Kelimeler.kelime_id="+kelime_id, null);

        while (c.moveToNext()) {

            Cumleler cu = new Cumleler(c.getInt(c.getColumnIndex("cumle_id"))
                    , c.getString(c.getColumnIndex("cumle_turkce"))
                    , c.getString(c.getColumnIndex("cumle_fransizca"))
                    , c.getString(c.getColumnIndex("cumle_resmi")));
            Sorular s = new Sorular(c.getInt(c.getColumnIndex("soru_id"))
                    , c.getString(c.getColumnIndex("soru_turkce"))
                    , c.getString(c.getColumnIndex("soru_fransizca"))
                    , c.getString(c.getColumnIndex("soru_resmi")));

            Kelimeler k = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
                    , c.getString(c.getColumnIndex("kelime_turkce"))
                    , c.getString(c.getColumnIndex("kelime_fransizca"))
                    , c.getString(c.getColumnIndex("kelime_turu"))
                    , c.getString(c.getColumnIndex("kelime_cinsiyeti"))
                    , c.getString(c.getColumnIndex("kelime_resmi"))

                    , cu, s);
            KelimelerArrayList.add(k);
        }

        return KelimelerArrayList;
    }

    public void kelimeSil(Database vt, int kelime_id) {
        SQLiteDatabase db = vt.getWritableDatabase();
        db.delete("Kelimeler", "kelime_id=?", new String[]{String.valueOf(kelime_id)});
        db.close();
    }

    public void kelimeEkle(Database vt, String kelime_turkce, String kelime_fransizca, String kelime_turu, String kelime_cinsiyeti, String kelime_resmi) {
        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("kelime_turkce", kelime_turkce);
        values.put("kelime_fransizca", kelime_fransizca);
        values.put("kelime_turu", kelime_turu);
        values.put("kelime_cinsiyeti", kelime_cinsiyeti);
        values.put("kelime_resmi", kelime_resmi);
        db.insertOrThrow("Kelimeler", null, values);
        db.close();
    }

    public void kelimeDuzenle(Database vt, int kelime_id, String kelime_turkce, String kelime_fransizca, String kelime_turu, String kelime_cinsiyeti, String kelime_resmi) {
        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("kelime_turkce", kelime_turkce);
        values.put("kelime_fransizca", kelime_fransizca);
        values.put("kelime_turu", kelime_turu);
        values.put("kelime_cinsiyeti", kelime_cinsiyeti);
        values.put("kelime_resmi", kelime_resmi);
        db.update("Kelimeler", values, "kelime_id=?", new String[]{String.valueOf(kelime_id)});

        db.close();
    }

    public static ArrayList<Kelimeler> kelimeGetir(Database vt, Context context) {
        ArrayList<Kelimeler> kelimeList = new ArrayList<>();
        ArrayList<String> turkceList = new ArrayList<>();
        ArrayList<String> fransizcaList = new ArrayList<>();
        ArrayList<String> turuList = new ArrayList<>();
        ArrayList<String> cinsiyetiList = new ArrayList<>();
        ArrayList<String> resmiList = new ArrayList<>();

        SQLiteDatabase db;

        try {
            db = context.openOrCreateDatabase("kelimeDatabase", Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM Kelimeler", null);

            int turkceIndex = cursor.getColumnIndex("kelime_turkce");
            int fransizcaIndex = cursor.getColumnIndex("kelime_fransizca");
            int turuIndex = cursor.getColumnIndex("kelime_turu");
            int cinsiyetiIndex = cursor.getColumnIndex("kelime_cinsiyeti");
            int resmiIndex = cursor.getColumnIndex("kelime_resmi");


            while (cursor.moveToNext()) {
                turkceList.add(cursor.getString(turkceIndex));
                fransizcaList.add(cursor.getString(fransizcaIndex));
                turuList.add(cursor.getString(turuIndex));
                cinsiyetiList.add(cursor.getString(cinsiyetiIndex));
                resmiList.add(cursor.getString(resmiIndex));


            }

            for (int i = 0; i < turkceList.size(); i++) {
                Kelimeler k = new Kelimeler();
                k.setKelime_turkce(turkceList.get(i));
                k.setKelime_fransizca(fransizcaList.get(i));
                k.setKelime_turu(turuList.get(i));
                k.setKelime_cinsiyeti(cinsiyetiList.get(i));
                k.setKelime_resmi(resmiList.get(i));



                kelimeList.add(k);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kelimeList;
    }


}
