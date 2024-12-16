package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class EslestirmeOyunuActivity extends AppCompatActivity {
    private BoardFragment fragment;
/*    private Button btnTurkce1,btnTurkce2,btnTurkce3,btnTurkce4,btnTurkce5,btnFransizca1,btnFransizca2,btnFransizca3,btnFransizca4,btnFransizca5;
    private ArrayList<Quizler> turkceSoruListe;

    private ArrayList<Quizler> fransizcaSecenekListe;
    private Quizler eslesenButonlar;
    private Database vt;
    private int soruSayac=0;
    private int yanlisSayac=0;
    private int dogruSayac=0;
    private int  canSayac=0;
    //
    private HashSet<Quizler> butonlariKaristirmaListe =new HashSet<>();

    private ArrayList<Quizler> fransizcaButonListe=new ArrayList<>();   */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eslestirme_oyunu);
        Display display=getWindowManager().getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);

        if (size.x>size.y)
            getSupportActionBar().hide();



        FragmentManager fm= getSupportFragmentManager();
        fragment = (BoardFragment) fm.findFragmentByTag("etiket");

        if (fragment==null){
            //Toast.makeText(this, "Sıfırdan oluştu", Toast.LENGTH_SHORT).show();
            fragment=new BoardFragment();
            fm.beginTransaction().add(R.id.container,fragment,"etiket").commit();
        }





   /*     btnFransizca1 = (Button) findViewById(R.id.btnFransizca1);
        btnFransizca2 = (Button) findViewById(R.id.btnFransizca2);
        btnFransizca3 = (Button) findViewById(R.id.btnFransizca3);
        btnFransizca4 = (Button) findViewById(R.id.btnFransizca4);
        btnFransizca5 = (Button) findViewById(R.id.btnFransizca5);
        btnTurkce1 = (Button) findViewById(R.id.btnTurkce1);
        btnTurkce2 = (Button) findViewById(R.id.btnTurkce2);
        btnTurkce3 = (Button) findViewById(R.id.btnTurkce3);
        btnTurkce4 = (Button) findViewById(R.id.btnTurkce4);
        btnTurkce5 = (Button) findViewById(R.id.btnTurkce5);

        vt = new Database(this);
        turkceSoruListe = new QuizDao().rastgele5kelimeGetir(vt, this);

        soruYukle();  */
    }






}