package com.example.kelimedata;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CumleDao {
    public ArrayList<Cumleler> tumCumleler(Database vt){
        ArrayList<Cumleler> cumlelerArrayList=new ArrayList<>();
        SQLiteDatabase db=vt.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM Cumleler",null);

        while (c.moveToNext()) {

            Cumleler cu = new Cumleler(c.getInt(c.getColumnIndex("cumle_id"))
                    , c.getString(c.getColumnIndex("cumle_turkce"))
                    , c.getString(c.getColumnIndex("cumle_fransizca"))
                    , c.getString(c.getColumnIndex("cumle_resmi")));
            cumlelerArrayList.add(cu);
        }
        return cumlelerArrayList;

    }
}
