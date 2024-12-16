package com.example.kelimedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuizDao {

    public static ArrayList<Quizler> rastgele5soruGetir(Database vt, Context context) {
        ArrayList<Quizler> quizList = new ArrayList<>();
         ArrayList<String> turkceList = new ArrayList<>();
     //   ArrayList<String> fransizcaList = new ArrayList<>();
       // ArrayList<String> resmiList = new ArrayList<>();

        SQLiteDatabase db;

        try {
            db = context.openOrCreateDatabase("kelimeDatabase", Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM Quizler ORDER BY RANDOM() LIMIT 5", null);


            int turkceIndex = cursor.getColumnIndex("turkce");
         //   int fransizcaIndex = cursor.getColumnIndex("fransizca");
         //   int resmiIndex = cursor.getColumnIndex("resmi");

            while (cursor.moveToNext()) {
                turkceList.add(cursor.getString(turkceIndex));
               // fransizcaList.add(cursor.getString(fransizcaIndex));
              //  resmiList.add(cursor.getString(resmiIndex));

            }

            for (int i = 0; i < turkceList.size(); i++) {
                Quizler k = new Quizler();
                k.setTurkce(turkceList.get(i));
               // k.setSoru_fransizca(fransizcaList.get(i));
              //  k.setSoru_resmi(resmiList.get(i));
                quizList.add(k);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizList;
    }

    public static ArrayList<Quizler> rastgele5cevapGetir(Database vt, Context context,int quiz_id) {
        ArrayList<Quizler> quizList = new ArrayList<>();
        //  ArrayList<String> turkceList = new ArrayList<>();
        ArrayList<String> fransizcaList = new ArrayList<>();
      // ArrayList<String> resmiList = new ArrayList<>();

        SQLiteDatabase db;

        try {
            db = context.openOrCreateDatabase("kelimeDatabase", Context.MODE_PRIVATE, null);
            Cursor cursor = db.rawQuery("SELECT * FROM Quizler WHERE quiz_id !="+quiz_id+" ORDER BY RANDOM() LIMIT 5", null);


            int turkceIndex = cursor.getColumnIndex("turkce");
            int fransizcaIndex = cursor.getColumnIndex("fransizca");
            int resmiIndex = cursor.getColumnIndex("resmi");

            while (cursor.moveToNext()) {
                //  turkceList.add(cursor.getString(turkceIndex));
                fransizcaList.add(cursor.getString(fransizcaIndex));
            //    resmiList.add(cursor.getString(resmiIndex));

            }

            for (int i = 0; i < fransizcaList.size(); i++) {
                Quizler k = new Quizler();
                //  k.setSoru_turkce(turkceList.get(i));
                k.setFransizca(fransizcaList.get(i));
             //   s.setSoru_resmi(resmiList.get(i));
                quizList.add(k);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizList;
    }


    public void quizEkle(Database vt, String turkce, String fransizca, String resmi) {
        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("turkce", turkce);
        values.put("fransizca", fransizca);

        values.put("resmi", resmi);
        db.insertOrThrow("Quizler", null, values);
        db.close();
    }
}


