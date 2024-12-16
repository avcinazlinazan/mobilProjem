package com.example.kelimedata;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Sozlukdao {
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

    public static ArrayList<Kelimeler> kelimeAra(Database vt, Context context,String ara) {
        ArrayList<Kelimeler> kelimeList = new ArrayList<>();
        ArrayList<String> turkceList = new ArrayList<>();
        ArrayList<String> fransizcaList = new ArrayList<>();
        SQLiteDatabase db;

        try {
            db = context.openOrCreateDatabase("kelimeDatabase", Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM Kelimeler WHERE kelime_turkce like '%"+ara+"%'", null);

            int turkceIndex = cursor.getColumnIndex("kelime_turkce");
            int fransizcaIndex = cursor.getColumnIndex("kelime_fransizca");

            while (cursor.moveToNext()) {
                turkceList.add(cursor.getString(turkceIndex));
                fransizcaList.add(cursor.getString(fransizcaIndex));
            }
            for (int i = 0; i < turkceList.size(); i++) {
                Kelimeler k = new Kelimeler();
                k.setKelime_turkce(turkceList.get(i));
                k.setKelime_fransizca(fransizcaList.get(i));

                kelimeList.add(k);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kelimeList;
    }

/*
    public ArrayList<Kelimeler> kelimeAra(Database vt, String arananKelime) {
        ArrayList<Kelimeler> kelimelerArrayList2 = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Kelimeler WHERE kelime_fransizca like '%" + arananKelime + "%'", null);
        while(c.moveToNext()){
            Kelimeler k = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
                    , c.getString(c.getColumnIndex("kelime_turkce"))
                    , c.getString(c.getColumnIndex("kelime_fransizca")));
            kelimelerArrayList2.add(k);

        }
        return kelimelerArrayList2;
    } */
}
