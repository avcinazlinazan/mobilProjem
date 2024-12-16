package com.example.kelimedata;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class cumle {
    private String Baslik1,Baslik2,cumle1,cumle2,cumle3,cumle4,cumle5,cumle6,cumle7,cumle8,cumle9,cumle10,cumle_7,cumle_8,cumle_9,cumle_10;
    private Bitmap resim;

    public cumle(String baslik1, String baslik2, String cumle1, String cumle2, String cumle3, String cumle4, String cumle5, String cumle6, String cumle7, String cumle8, String cumle9, String cumle10, String cumle_7, String cumle_8, String cumle_9, String cumle_10, Bitmap resim) {
        Baslik1 = baslik1;
        Baslik2 = baslik2;
        this.cumle1 = cumle1;
        this.cumle2 = cumle2;
        this.cumle3 = cumle3;
        this.cumle4 = cumle4;
        this.cumle5 = cumle5;
        this.cumle6 = cumle6;
        this.cumle7 = cumle7;
        this.cumle8 = cumle8;
        this.cumle9 = cumle9;
        this.cumle10 = cumle10;
        this.cumle_7 = cumle_7;
        this.cumle_8 = cumle_8;
        this.cumle_9 = cumle_9;
        this.cumle_10 = cumle_10;
        this.resim = resim;
    }

    public String getBaslik1() {
        return Baslik1;
    }

    public void setBaslik1(String baslik1) {
        Baslik1 = baslik1;
    }

    public String getBaslik2() {
        return Baslik2;
    }

    public void setBaslik2(String baslik2) {
        Baslik2 = baslik2;
    }

    public String getCumle1() {
        return cumle1;
    }

    public void setCumle1(String cumle1) {
        this.cumle1 = cumle1;
    }

    public String getCumle2() {
        return cumle2;
    }

    public void setCumle2(String cumle2) {
        this.cumle2 = cumle2;
    }

    public String getCumle3() {
        return cumle3;
    }

    public void setCumle3(String cumle3) {
        this.cumle3 = cumle3;
    }

    public String getCumle4() {
        return cumle4;
    }

    public void setCumle4(String cumle4) {
        this.cumle4 = cumle4;
    }

    public String getCumle5() {
        return cumle5;
    }

    public void setCumle5(String cumle5) {
        this.cumle5 = cumle5;
    }

    public String getCumle6() {
        return cumle6;
    }

    public void setCumle6(String cumle6) {
        this.cumle6 = cumle6;
    }

    public String getCumle7() {
        return cumle7;
    }

    public void setCumle7(String cumle7) {
        this.cumle7 = cumle7;
    }

    public String getCumle8() {
        return cumle8;
    }

    public void setCumle8(String cumle8) {
        this.cumle8 = cumle8;
    }

    public String getCumle9() {
        return cumle9;
    }

    public void setCumle9(String cumle9) {
        this.cumle9 = cumle9;
    }

    public String getCumle10() {
        return cumle10;
    }

    public void setCumle10(String cumle10) {
        this.cumle10 = cumle10;
    }

    public Bitmap getResim() {
        return resim;
    }

    public void setResim(Bitmap resim) {
        this.resim = resim;
    }

    public String getCumle_7() {
        return cumle_7;
    }

    public void setCumle_7(String cumle_7) {
        this.cumle_7 = cumle_7;
    }

    public String getCumle_8() {
        return cumle_8;
    }

    public void setCumle_8(String cumle_8) {
        this.cumle_8 = cumle_8;
    }

    public String getCumle_9() {
        return cumle_9;
    }

    public void setCumle_9(String cumle_9) {
        this.cumle_9 = cumle_9;
    }

    public String getCumle_10() {
        return cumle_10;
    }

    public void setCumle_10(String cumle_10) {
        this.cumle_10 = cumle_10;
    }
}
