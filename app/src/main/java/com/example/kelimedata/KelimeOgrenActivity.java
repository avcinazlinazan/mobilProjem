package com.example.kelimedata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class KelimeOgrenActivity extends AppCompatActivity {
    private TextView textViewDogru,textViewYanlis,textViewSoruSayisi;
    private Button buttonA,buttonB,buttonC,buttonD,btnTebrikler;
    private ImageView imageSoruResmi,imageButtonCik2;
    Animation anim_left;

    private ProgressBar pr;
    private float maksimumProgres = 100f, artacakProgress, progresMiktari = 0;

    private ArrayList<Sorular> sorularList;
    private ArrayList<Sorular> yanlisSeceneklerList;
    private Sorular dogruSoru;
    private Database vt;
    //sayaçlar
    private int soruSayac=0;
    private int yanlisSayac=0;
    private int dogruSayac=0;
    private int canSayisi;
    //secenekler
    private HashSet<Sorular> secenekleriKaristirmaList=new HashSet<>();
    private ArrayList<Sorular> seceneklerListe=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_ogren);
        pr = (ProgressBar) findViewById(R.id.progressBarDurum3);


        textViewDogru=(TextView)findViewById(R.id.textViewDogru);
        textViewYanlis=(TextView)findViewById(R.id.textViewYanlis);
        textViewSoruSayisi=(TextView)findViewById(R.id.textViewSoruSayisi);

        imageSoruResmi=(ImageView)findViewById(R.id.imageSoruResmi);
        buttonA=(Button)findViewById(R.id.buttonA);
        buttonB=(Button)findViewById(R.id.buttonB);
        buttonC=(Button)findViewById(R.id.buttonC);
        buttonD=(Button)findViewById(R.id.buttonD);
        imageButtonCik2=(ImageView)findViewById(R.id.imageButtonCik2);
        imageButtonCik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(KelimeOgrenActivity.this,ContentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        vt=new Database(this);
        sorularList=new SorularDao().rastgele10soruGetir(vt,this);
        soruYukle();


        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dogruKontrol(buttonA);
                sayacKontrol();
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dogruKontrol(buttonB);
                sayacKontrol();
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dogruKontrol(buttonC);
                sayacKontrol();
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dogruKontrol(buttonD);
                sayacKontrol();
            }
        });


    }

    public void soruYukle(){
        textViewSoruSayisi.setText((soruSayac+1)+".SORU");
        textViewDogru.setText("Doğru: "+dogruSayac);
        textViewYanlis.setText("Yanlış: "+yanlisSayac);

        dogruSoru=sorularList.get(soruSayac);
        yanlisSeceneklerList=new SorularDao().rastgele3YanlissoruGetir(vt,this,dogruSoru.getSoru_id());

        imageSoruResmi.setImageResource(getResources().getIdentifier(dogruSoru.getSoru_resmi(),"drawable",getPackageName()));
        secenekleriKaristirmaList.clear();
        secenekleriKaristirmaList.add(dogruSoru);
        secenekleriKaristirmaList.add(yanlisSeceneklerList.get(0));
        secenekleriKaristirmaList.add(yanlisSeceneklerList.get(1));
        secenekleriKaristirmaList.add(yanlisSeceneklerList.get(2));
        seceneklerListe.clear();
        for(Sorular s:secenekleriKaristirmaList){

            seceneklerListe.add(s);
        }
        buttonA.setText(seceneklerListe.get(0).getSoru_fransizca());
        buttonB.setText(seceneklerListe.get(1).getSoru_fransizca());
        buttonC.setText(seceneklerListe.get(2).getSoru_fransizca());
        buttonD.setText(seceneklerListe.get(3).getSoru_fransizca());

        artacakProgress = maksimumProgres / 10;
        progresMiktari += artacakProgress;
        pr.setProgress((int) progresMiktari);

    }
    public void dogruKontrol(Button button){
        String buttonYazi=button.getText().toString();
        String dogruCevap=dogruSoru.getSoru_fransizca();

        if (buttonYazi.equals(dogruCevap)) {
            dogruSayac++;
           Toast.makeText(this,"Tebrikler" ,Toast.LENGTH_SHORT).show();
        }else{
            yanlisSayac++;
            Toast.makeText(this,"Malesef yanlış\n Doğru cevap:\n"+dogruCevap,Toast.LENGTH_LONG).show();
        }
    }
    public void sayacKontrol() {
        soruSayac++;
        if(soruSayac !=10 ){
            soruYukle();
        }else{
            Intent intent=new Intent(KelimeOgrenActivity.this,UyeOlActivity.class);
            intent.putExtra("dogruSayac",dogruSayac);
            startActivity(intent);
            finish();
        }
    }



}