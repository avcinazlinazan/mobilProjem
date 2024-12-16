package com.example.kelimedata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ContentActivity extends AppCompatActivity {
    //Sorular İçin Listeler
    private String[] sorularList = {"Mutfakta iş yaparken veya yemek yerken kullanılan aletler nelerdir?", "İç Anadolu Bölgesindeki İller?"};
    private String[] sorularKodList = {"mutfakS1", "illerS1"};

    //Kelimeler İçin Listeler
    private String[] kelimelerList = {"Çatal", "Bıçak", "Kaşık", "Tabak", "Bulaşık Süngeri", "Bulaşık Teli", "Tencere", "Tava", "Çaydanlık",
            "Mutfak Robotu", "Kesme Tahtası", "Süzgeç",
            "Aksaray", "Ankara", "Çankırı", "Eskişehir", "Karaman", "Kayseri", "Kırıkkale", "Kırşehir", "Konya",
            "Nevşehir", "Niğde", "Sivas", "Yozgat"};
    private String[] kelimelerKodList = {"mutfakS1", "mutfakS1", "mutfakS1", "mutfakS1", "mutfakS1", "mutfakS1", "mutfakS1", "mutfakS1",
            "mutfakS1", "mutfakS1", "mutfakS1", "mutfakS1",
            "illerS1", "illerS1", "illerS1", "illerS1", "illerS1", "illerS1", "illerS1", "illerS1", "illerS1",
            "illerS1", "illerS1", "illerS1", "illerS1"};

    private SQLiteDatabase database;
    private Cursor cursor;
    Button btnKonu,btnCumle,btnAlistirma,btnKelimeOgren,btnKelimeEs,btnKelimeResimEs,btnKelimeRenkEs,btnQuizResim,btncumle2;
    Intent intent;
    private ProgressBar mProgress;
    private TextView mTextView;
    private float maksimumProgres = 100f, artacakProgress, progresMiktari = 0;
    static public HashMap<String, String> sorularHashmap;
    private String sqlSorgusu;
    private SQLiteStatement statement;
    private ImageView imageButtonCik3;
    final Context context =this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        mProgress = (ProgressBar) findViewById(R.id.progressBarDurum);
        mTextView=(TextView)findViewById(R.id.textViewAdi);


        btnKonu=(Button)findViewById(R.id.btnKonu);
        btnCumle=(Button)findViewById(R.id.btnSozluk);
        btnAlistirma=(Button)findViewById(R.id.btnAlistirma);

        btnKelimeOgren=(Button)findViewById(R.id.btnKelimeOgren);
        btnKelimeEs=(Button)findViewById(R.id.btnCumle);
        btnKelimeResimEs=(Button)findViewById(R.id.btnKelimeResimEs);
        btnKelimeRenkEs=(Button)findViewById(R.id.btnKelimeRenkEs);

        imageButtonCik3=(ImageView)findViewById(R.id.imageButtonCik3);
        imageButtonCik3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(context);//builder tanımlanır
                //alert dialog başlıgını tanımlıyoruz
                alertDialogBuilder.setTitle("Aprendre Toujour");
                alertDialogBuilder
                        .setMessage("Uygulamayı kapatmak istiyor musunuz?")
                        .setCancelable(false)
                        .setIcon(R.mipmap.ic_launcher)
                        //evete basınca bu işlemler oluyor
                        .setPositiveButton("evet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                uygulamadanCik();
                                finish();
                            }
                        })//iptale basınca da bunlar calışıyor
                        .setNegativeButton("iptal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                //alert dialog nesnesi oluşturuyoruz
                AlertDialog alertDialog=alertDialogBuilder.create();
                //alerti gösteriyoruz
                alertDialog.show();

            }
        });

   /*     sorularHashmap = new HashMap<>();

        try {
            database = this.openOrCreateDatabase("kelimeDatabase", MODE_PRIVATE, null);
        //    database.execSQL("CREATE TABLE IF NOT EXISTS Ayarlar (k_adi VARCHAR, k_heart VARCHAR, k_image BLOB)");
            cursor = database.rawQuery("SELECT * FROM Ayarlar", null);

            if (cursor.getCount() < 1)
             //   database.execSQL("INSERT INTO Ayarlar (k_adi, k_heart) VALUES ('Oyuncu', '0')");

            database.execSQL("CREATE TABLE IF NOT EXISTS Sorular2 (soru_id INTEGER PRIMARY KEY, sKod TEXT UNIQUE, FransizcaSoru TEXT )");
            database.execSQL("DELETE FROM Sorular2");
            sqlSorulariEkle();

            database.execSQL("CREATE TABLE IF NOT EXISTS Kelimeler2 (kKod TEXT, kelime TEXT, FOREIGN KEY (kKod) REFERENCES Sorular2 (sKod))");
            database.execSQL("DELETE FROM Kelimeler2");
            sqlKelimeleriEkle();

            cursor = database.rawQuery("SELECT * FROM Sorular2", null);
            artacakProgress = maksimumProgres / cursor.getCount();

            int sKodIndex = cursor.getColumnIndex("sKod");
            int soruIndex = cursor.getColumnIndex("FransizcaSoru");


            while (cursor.moveToNext()) {
                sorularHashmap.put(cursor.getString(sKodIndex), cursor.getString(soruIndex));
                progresMiktari += artacakProgress;
                mProgress.setProgress((int) progresMiktari);
            }

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
                      */
    }
 /*   private void sqlSorulariEkle(){
        try {
            for (int s = 0; s < sorularList.length; s++){
                sqlSorgusu = "INSERT INTO Sorular2 (sKod, FransizcaSoru) VALUES (?, ?)";
                statement = database.compileStatement(sqlSorgusu);
                statement.bindString(1, sorularKodList[s]);
                statement.bindString(2, sorularList[s]);;
                statement.execute();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void sqlKelimeleriEkle(){
        try {
            for (int k = 0; k < kelimelerList.length; k++){
                sqlSorgusu = "INSERT INTO Kelimeler2 (kKod, kelime) VALUES (?, ?)";
                statement = database.compileStatement(sqlSorgusu);
                statement.bindString(1, kelimelerKodList[k]);
                statement.bindString(2, kelimelerList[k]);
                statement.execute();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
*/
 private void uygulamadanCik(){
     moveTaskToBack(true);
     android.os.Process.killProcess(android.os.Process.myPid());
     System.exit(0);
 }
    public void Onclick(View view){
        switch (view.getId()) {
            case R.id.btnKonu:
                intent = new Intent(ContentActivity.this,GenelActivity.class);
                startActivity(intent);
                break;
            case R.id.btnAlistirma:
                intent = new Intent(ContentActivity.this,AlistirmaActivity.class);
                startActivity(intent);
                break;

            case R.id.btnKelimeOgren:
                intent = new Intent(ContentActivity.this,KelimeOgrenActivity.class);
                startActivity(intent);
                break;
            case R.id.btnKelimeOgren2:

                intent = new Intent(ContentActivity.this,Quiz2ctivity.class);

                startActivity(intent);
                break;

            case R.id.btnSozluk:
                intent = new Intent(ContentActivity.this,SozlukActivity2.class);
                startActivity(intent);
                break;
            case R.id.btnCumle:
                 intent = new Intent(ContentActivity.this,CumleEkleActivity.class);
                startActivity(intent);
                break;
            case R.id.btnKelimeEs:
             intent = new Intent(ContentActivity.this,ButonKelimeEsleActivity2.class);
                startActivity(intent);
                break;
            case R.id.btnKelimeResimEs:
                intent = new Intent(ContentActivity.this,KelimeEslemeActivity.class);
                startActivity(intent);
                 break;
            case R.id.btnKelimeRenkEs:
                intent= new Intent(ContentActivity.this,ButonEslemeActivity.class);
                startActivity(intent);
                break;


            default:
                Toast.makeText(getApplicationContext(),"Butona tıklanmadı",Toast.LENGTH_SHORT).show();
        }







    }
    public void alertQuiz(){
        LayoutInflater layout=LayoutInflater.from(this);
        View tasarim=layout.inflate(R.layout.alert_quiz,null);


        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Sayılar");
        ad.setView(tasarim);
        ad.setPositiveButton("Resimli Quiz", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


               // Toast.makeText(getApplicationContext(),"Fransızca sayıların okunuşunu öğrendiniz",Toast.LENGTH_SHORT).show();

            }
        });
        ad.setNegativeButton("Normal Quiz", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        ad.create().show();
    }
}