package com.example.kelimedata;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Kelime {
    private String turkce,fransizca,turu,cinsiyeti,cumle,cumleF;
    private Bitmap resmi;

    public Kelime() {
    }

    public Kelime(String turkce, String fransizca, String turu, String cinsiyeti,String cumle,String cumleF, Bitmap resmi) {
        this.turkce = turkce;
        this.fransizca = fransizca;
        this.turu = turu;
        this.cinsiyeti = cinsiyeti;
        this.resmi = resmi;
        this.cumle=cumle;
        this.cumleF=cumleF;

    }

    public String getCumle() {
        return cumle;
    }

    public void setCumle(String cumle) {
        this.cumle = cumle;
    }

    public String getCumleF() {
        return cumleF;
    }

    public void setCumleF(String cumleF) {
        this.cumleF = cumleF;
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        this.turkce = turkce;
    }

    public String getFransizca() {
        return fransizca;
    }

    public void setFransizca(String fransizca) {
        this.fransizca = fransizca;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getCinsiyeti() {
        return cinsiyeti;
    }

    public void setCinsiyeti(String cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public Bitmap getResmi() {
        return resmi;
    }

    public void setResmi(Bitmap resmi) {
        this.resmi = resmi;
    }


    static public ArrayList<Kelime> getData(Context context){
        ArrayList<Kelime> kelimeList = new ArrayList<>();
        ArrayList<String> turkceList =new ArrayList<>();
        ArrayList<String> fransizcaList=new ArrayList<>();
        ArrayList<String> turuList=new ArrayList<>();
        ArrayList<String> cinsiyetiList=new ArrayList<>();
        ArrayList<Bitmap> resmiList=new ArrayList<>();
        try {
            SQLiteDatabase database =context.openOrCreateDatabase("Kelimeler",Context.MODE_PRIVATE,null);
            Cursor cursor=database.rawQuery("SELECT * FROM kelimeler",null);

            int turkceIndex=cursor.getColumnIndex("Turkce");
            int fransizcaIndex=cursor.getColumnIndex("Fransizca");
            int turuIndex=cursor.getColumnIndex("Turu");
            int cinsiyetiIndex=cursor.getColumnIndex("Cinsiyeti");
            int resmiIndex=cursor.getColumnIndex("Kelime_Resmi");
            while (cursor.moveToNext()){
                turkceList.add(cursor.getString(turkceIndex));
                fransizcaList.add(cursor.getString(fransizcaIndex));
                turuList.add(cursor.getString(turuIndex));
                cinsiyetiList.add(cursor.getString(cinsiyetiIndex));
                byte[] gelenResimByte=cursor.getBlob(resmiIndex);
                Bitmap gelenResim= BitmapFactory.decodeByteArray(gelenResimByte,0,gelenResimByte.length);
                resmiList.add(gelenResim);
            }
            cursor.close();
            for(int i=0; i< turkceList.size();i++){
                Kelime kelime=new Kelime();
                kelime.setTurkce(turkceList.get(i));
                kelime.setFransizca(fransizcaList.get(i));
                kelime.setTuru(turuList.get(i));
                kelime.setCinsiyeti(cinsiyetiList.get(i));
                kelime.setResmi(resmiList.get(i));

                kelimeList.add(kelime);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return kelimeList;
    }


}
