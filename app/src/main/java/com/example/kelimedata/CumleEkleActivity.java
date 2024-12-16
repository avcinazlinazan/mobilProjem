package com.example.kelimedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CumleEkleActivity extends AppCompatActivity {

    private SQLiteDatabase database;

    private ArrayList<String> sorularList;
    private ArrayList<String> sorularKodList;
    private ArrayList<String> kelimelerList;
    //random degiskenler
    private Random rndSoru, rndKelime, rndHarf;
    private int rndSoruNumber, rndKelimeNumber, rndHarfNumber;
    private String rastgeleSoru, rastgeleSoruKodu, rastgeleKelime, kelimeBilgisi="", textTahminDegeri;
    private int rastgeleBelirlenecekHarfSayisi;


    private ProgressBar mProgress;
    private TextView mTextView,textViewQuestion,textViewQuest;
    private Cursor cursor;
    private float maksimumProgres = 100f, artacakProgress, progresMiktari = 0;
    static public HashMap<String, String> sorularHashmap;
    private String sqlSorgusu;
    private SQLiteStatement statement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cumle_ekle);
        sorularHashmap = new HashMap<>();
        mProgress = (ProgressBar) findViewById(R.id.progressBarDurum);
        textViewQuestion=(TextView)findViewById(R.id.textViewQuestion);
        textViewQuest=(TextView)findViewById(R.id.textViewQuest);
/*
        sorularList=new ArrayList<>();
        sorularKodList=new ArrayList<>();
        kelimelerList=new ArrayList<>();
        rndSoru=new Random();
        rndKelime=new Random();

        for(Map.Entry soru: ContentActivity.sorularHashmap.entrySet()){
            sorularList.add(String.valueOf(soru.getValue()));
            sorularKodList.add(String.valueOf(soru.getKey()));
        }
        rndSoruNumber=rndSoru.nextInt(sorularKodList.size());
        rastgeleSoru=sorularList.get(rndSoruNumber);
        rastgeleSoruKodu=sorularKodList.get(rndSoruNumber);
        textViewQuestion.setText(rastgeleSoru);
        try {
            database = this.openOrCreateDatabase("kelimeDatabase", MODE_PRIVATE, null);
            cursor=database.rawQuery("SELECT * FROM Kelimeler2 WHERE kKod=?",new String[]{sorularKodList.get(rndSoruNumber)});
            int kelimeIndex = cursor.getColumnIndex("kelime");

            while (cursor.moveToNext()){
                kelimelerList.add(cursor.getString(kelimeIndex));
            }
            cursor.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        rndKelimeNumber=rndKelime.nextInt(kelimelerList.size());
        rastgeleKelime=kelimelerList.get(rndKelimeNumber);

        for(int i=0;i< rastgeleKelime.length();i++){

        }
*/






    }


}

