package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class ButonKelimeEsleActivity2 extends AppCompatActivity {
    private Button btnTurkce1,btnTurkce2,btnTurkce3,btnTurkce4,btnTurkce5,btnFransizca1,btnFransizca2,btnFransizca3,btnFransizca4,btnFransizca5;
    private TextView textViewDogru,textViewYanlis,textViewSoruSayisi;
    private Database vt;
    private ArrayList<Quizler> turkceSorularList2,  turkceSorularList,  turkceSorularList3,  turkceSorularList4,  turkceSorularList5;
    private ArrayList<Quizler> fransizcaCevaplarList1,fransizcaCevaplarList2,fransizcaCevaplarList3,fransizcaCevaplarList4,fransizcaCevaplarList5;
    private Quizler dogruSoru1,SoruSayisi,dogruSoru2,dogruSoru3,dogruSoru4,dogruSoru5;

    private HashSet<Quizler> secenekleriKaristirmaList=new HashSet<>();
    private ArrayList<Quizler> seceneklerListe1=new ArrayList<>();
    private ArrayList<Quizler> seceneklerListe2=new ArrayList<>();
    private ArrayList<Quizler> seceneklerListe3=new ArrayList<>();
    private ArrayList<Quizler> seceneklerListe4=new ArrayList<>();
    private ArrayList<Quizler> seceneklerListe5=new ArrayList<>();

    private int soruSayac=0;
    private int yanlisSayac=0;
    private int dogruSayac=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buton_kelime_esle2);

        textViewDogru=(TextView)findViewById(R.id.textViewDogru);
        textViewYanlis=(TextView)findViewById(R.id.textViewYanlis);
        textViewSoruSayisi=(TextView)findViewById(R.id.textViewSoruSayisi);

        btnFransizca1 = (Button) findViewById(R.id.btnFransizca1);
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
        turkceSorularList=new QuizDao().rastgele5soruGetir(vt,this);
  /*      turkceSorularList1=new QuizDao().rastgele5soruGetir(vt,this);
        turkceSorularList2=new QuizDao().rastgele5soruGetir(vt,this);
        turkceSorularList3=new QuizDao().rastgele5soruGetir(vt,this);
        turkceSorularList4=new QuizDao().rastgele5soruGetir(vt,this);  */
       soruYukle();
    }
    public void soruYukle(){
        textViewSoruSayisi.setText((soruSayac+1)+" .SORU");
        textViewDogru.setText("Doğru: "+dogruSayac);
        textViewYanlis.setText("Yanlış: "+yanlisSayac);

        dogruSoru1=turkceSorularList.get(soruSayac);
    /*    dogruSoru2=turkceSorularList2.get(soruSayac);
        dogruSoru3=turkceSorularList3.get(soruSayac);
        dogruSoru4=turkceSorularList4.get(soruSayac);
        dogruSoru5=turkceSorularList5.get(soruSayac);  */


        fransizcaCevaplarList1=new QuizDao().rastgele5cevapGetir(vt,this,dogruSoru1.getQuiz_id());
/*        fransizcaCevaplarList2=new QuizDao().rastgele5cevapGetir(vt,this,dogruSoru2.getQuiz_id());
        fransizcaCevaplarList3=new QuizDao().rastgele5cevapGetir(vt,this,dogruSoru3.getQuiz_id());
        fransizcaCevaplarList4=new QuizDao().rastgele5cevapGetir(vt,this,dogruSoru4.getQuiz_id());
        fransizcaCevaplarList5=new QuizDao().rastgele5cevapGetir(vt,this,dogruSoru5.getQuiz_id());*/

        btnTurkce1.setText(turkceSorularList.get(0).getTurkce());
        btnTurkce2.setText(turkceSorularList.get(1).getTurkce());
        btnTurkce3.setText(turkceSorularList.get(2).getTurkce());
        btnTurkce4.setText(turkceSorularList.get(3).getTurkce());
        btnTurkce5.setText(turkceSorularList.get(4).getTurkce());



       secenekleriKaristirmaList.clear();

        secenekleriKaristirmaList.add(fransizcaCevaplarList1.get(0));
        secenekleriKaristirmaList.add(fransizcaCevaplarList1.get(1));
        secenekleriKaristirmaList.add(fransizcaCevaplarList1.get(2));
        secenekleriKaristirmaList.add(fransizcaCevaplarList1.get(3));
        secenekleriKaristirmaList.add(fransizcaCevaplarList1.get(4));


        seceneklerListe1.clear();
        for(Quizler k:secenekleriKaristirmaList){
            seceneklerListe1.add(k);
        }
        btnFransizca1.setText(seceneklerListe1.get(0).getFransizca());
        btnFransizca2.setText(seceneklerListe1.get(1).getFransizca());
        btnFransizca3.setText(seceneklerListe1.get(2).getFransizca());
        btnFransizca4.setText(seceneklerListe1.get(3).getFransizca());
        btnFransizca5.setText(seceneklerListe1.get(4).getFransizca());





    }
}