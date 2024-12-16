package com.example.kelimedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SorularDao {



    public static ArrayList<Sorular> rastgele10soruGetir(Database vt, Context context) {
        ArrayList<Sorular> soruList = new ArrayList<>();
        ArrayList<String> turkceList = new ArrayList<>();
        ArrayList<String> fransizcaList = new ArrayList<>();
        ArrayList<String> resmiList = new ArrayList<>();
        SQLiteDatabase db;
        try {
            db = context.openOrCreateDatabase("kelimeDatabase", Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM Sorular ORDER BY RANDOM() LIMIT 10", null);
            int turkceIndex = cursor.getColumnIndex("soru_turkce");
            int fransizcaIndex = cursor.getColumnIndex("soru_fransizca");
            int resmiIndex = cursor.getColumnIndex("soru_resmi");

            while (cursor.moveToNext()) {
                turkceList.add(cursor.getString(turkceIndex));
                fransizcaList.add(cursor.getString(fransizcaIndex));
                resmiList.add(cursor.getString(resmiIndex));

            }
            for (int i = 0; i < fransizcaList.size(); i++) {
               Sorular s = new Sorular();
                s.setSoru_turkce(turkceList.get(i));
                s.setSoru_fransizca(fransizcaList.get(i));
                s.setSoru_resmi(resmiList.get(i));
                soruList.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soruList;
    }

    public static ArrayList<Sorular> rastgele3YanlissoruGetir(Database vt, Context context,int soru_id) {
        ArrayList<Sorular> soruList = new ArrayList<>();
        ArrayList<String> turkceList = new ArrayList<>();
        ArrayList<String> fransizcaList = new ArrayList<>();
        ArrayList<String> resmiList = new ArrayList<>();

        SQLiteDatabase db;

        try {
            db = context.openOrCreateDatabase("kelimeDatabase", Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM Sorular WHERE soru_id !="+soru_id+" ORDER BY RANDOM() LIMIT 3", null);


            int turkceIndex = cursor.getColumnIndex("soru_turkce");
            int fransizcaIndex = cursor.getColumnIndex("soru_fransizca");
            int resmiIndex = cursor.getColumnIndex("soru_resmi");

            while (cursor.moveToNext()) {
                turkceList.add(cursor.getString(turkceIndex));
                fransizcaList.add(cursor.getString(fransizcaIndex));
                resmiList.add(cursor.getString(resmiIndex));

            }

            for (int i = 0; i < fransizcaList.size(); i++) {
                Sorular s = new Sorular();
                s.setSoru_turkce(turkceList.get(i));
                s.setSoru_fransizca(fransizcaList.get(i));
                s.setSoru_resmi(resmiList.get(i));
                soruList.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return soruList;
    }




    public void soruEkle(Database vt, String soru_turkce, String soru_fransizca, String soru_resmi) {
        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("soru_turkce", soru_turkce);
        values.put("soru_fransizca", soru_fransizca);

        values.put("soru_resmi", soru_resmi);
        db.insertOrThrow("Sorular", null, values);
        db.close();
    }

    public static ArrayList<Sorular> rastgele1soruGetir(Database vt, Context context) {
        ArrayList<Sorular> soruList = new ArrayList<>();
        ArrayList<String> turkceList = new ArrayList<>();
        ArrayList<String> fransizcaList = new ArrayList<>();
        ArrayList<String> resmiList = new ArrayList<>();

        SQLiteDatabase db;

        try {
            db = context.openOrCreateDatabase("kelimeDatabase", Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM Sorular ORDER BY RANDOM() LIMIT 1", null);


            int turkceIndex = cursor.getColumnIndex("soru_turkce");
            int fransizcaIndex = cursor.getColumnIndex("soru_fransizca");
            int resmiIndex = cursor.getColumnIndex("soru_resmi");

            while (cursor.moveToNext()) {
                turkceList.add(cursor.getString(turkceIndex));
                fransizcaList.add(cursor.getString(fransizcaIndex));
                resmiList.add(cursor.getString(resmiIndex));

            }

            for (int i = 0; i < fransizcaList.size(); i++) {
                Sorular s = new Sorular();
                s.setSoru_turkce(turkceList.get(i));
                s.setSoru_fransizca(fransizcaList.get(i));
                s.setSoru_resmi(resmiList.get(i));
                soruList.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return soruList;
    }

        /*   public ArrayList<Sorular> tumSorular(Database vt){
           ArrayList<Sorular> sorularArrayList=new ArrayList<>();
           SQLiteDatabase db=vt.getWritableDatabase();
           Cursor c=db.rawQuery("SELECT * FROM Sorular",null);

           while (c.moveToNext()) {

               Sorular s = new Sorular(c.getInt(c.getColumnIndex("soru_id"))
                       , c.getString(c.getColumnIndex("soru_turkce"))
                       , c.getString(c.getColumnIndex("soru_fransizca"))
                       , c.getString(c.getColumnIndex("soru_resmi")));
               sorularArrayList.add(s);
           }
           return sorularArrayList;

       }

    public ArrayList<Sorular> rastgele10soruGetir(Database vt) {
        ArrayList<Sorular> sorularArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Sorular ORDER BY RANDOM() LIMIT 10", null);


        while (c.moveToNext()) {

            Sorular s = new Sorular(c.getInt(c.getColumnIndex("soru_id"))
                    , c.getString(c.getColumnIndex("soru_turkce"))
                    , c.getString(c.getColumnIndex("soru_fransizca"))
                    , c.getString(c.getColumnIndex("soru_resmi")));
            sorularArrayList.add(s);
        }
        return sorularArrayList;

    }

    public ArrayList<Sorular> rastgele3YanlisGetir(Database vt, int soru_id) {
        ArrayList<Sorular> sorularArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Sorular WWHERE soru_id !="+soru_id+" ORDER BY RANDOM() LIMIT 3", null);

        while (c.moveToNext()) {

            Sorular s = new Sorular(c.getInt(c.getColumnIndex("soru_id"))
                    , c.getString(c.getColumnIndex("soru_turkce"))
                    , c.getString(c.getColumnIndex("soru_fransizca"))
                    , c.getString(c.getColumnIndex("soru_resmi")));
            sorularArrayList.add(s);
        }
        return sorularArrayList;



} */



}
