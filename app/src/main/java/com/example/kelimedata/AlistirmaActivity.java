package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class AlistirmaActivity extends AppCompatActivity {
    private Button btnFiil1,btnFiil2,btnFiil3,btnIsim1,btnIsim2,btnIsim3,btnIsim4,btnZamir1,btnZamir2,btnSifat1,btnSifat2,btnArticle1,btnArticle2,btnArticle3,btnZarf1,btnZarf2;
    private Animation anim;
    private TextView textViewDogru,textViewYanlis,textViewSoruSayisi,textViewSoruTurkce;

    private ArrayList<Sorular> sorularList;
    private ArrayList<Sorular> cevaplarList;
    private Sorular dogruSoru;
    private Database vt;
    //sayaçlar
    private int soruSayac=0;
    private int yanlisSayac=0;
    private int dogruSayac=0;
    //secenekler
    private HashSet<Sorular> secenekleriKaristirmaList=new HashSet<>();
    private ArrayList<Sorular> seceneklerListe=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alistirma);

        textViewDogru=(TextView)findViewById(R.id.textViewDogru);
        textViewYanlis=(TextView)findViewById(R.id.textViewYanlis);
        textViewSoruSayisi=(TextView)findViewById(R.id.textViewSoruSayi);
        textViewSoruTurkce=(TextView)findViewById(R.id.textViewSoruF);



        btnFiil1=(Button)findViewById(R.id.btnFiil1);
        btnFiil2=(Button)findViewById(R.id.btnFiil2);
        btnFiil3=(Button)findViewById(R.id.btnFiil3);
        btnIsim1=(Button)findViewById(R.id.btnIsim1);
        btnIsim4=(Button)findViewById(R.id.btnIsim4);
        btnIsim2=(Button)findViewById(R.id.btnIsim2);
        btnIsim3=(Button)findViewById(R.id.btnIsim3);
        btnZamir1=(Button)findViewById(R.id.btnZamir1);
        btnZamir2=(Button)findViewById(R.id.btnZamir2);
        btnZarf1=(Button)findViewById(R.id.btnZarf1);
        btnZarf2=(Button)findViewById(R.id.btnZarf2);
        btnArticle1=(Button)findViewById(R.id.btnArticle1);
        btnArticle2=(Button)findViewById(R.id.btnArticle2);
        btnArticle3=(Button)findViewById(R.id.btnArticle3);
        btnSifat1=(Button)findViewById(R.id.btnSifat1);
        btnSifat2=(Button)findViewById(R.id.btnSifat2);
        vt=new Database(this);
        sorularList=new SorularDao().rastgele1soruGetir(vt,this);
        soruYukle();


        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animasyon); // Create the animation.
       // btnFiil1.startAnimation(anim);
    }
    public void clickAc(View view){
        switch (view.getId()) {
            case R.id.btnFiil1:
             //   startAnimation(anim);



                break;
            case R.id.btnFiil2:

                break;
            case R.id.btnFiil3:

                break;
            case R.id.btnIsim1:

                break;
            case R.id.btnIsim2:

                break;
            case R.id.btnIsim3:

                break;
            case R.id.btnIsim4:

                break;
            case R.id.btnZamir1:

                break;
            case R.id.btnZamir2:

                break;
            case R.id.btnZarf1:

                break;
            case R.id.btnZarf2:

                break;
            case R.id. btnArticle1:

                break;
            case R.id.btnArticle2:

                break;
            case R.id. btnArticle3:

                break;
            case R.id.btnSifat1:

                break;
            case R.id.btnSifat2:

                break;

            default:
                Toast.makeText(getApplicationContext(),"Butona tıklanmadı",Toast.LENGTH_SHORT).show();
        }
    }

    public void soruYukle(){
    /*    textViewSoruSayisi.setText((soruSayac+1)+".SORU");
        textViewDogru.setText("Doğru: "+dogruSayac);
        textViewYanlis.setText("Yanlış: "+yanlisSayac);

        dogruSoru=sorularList.get(soruSayac);
        cevaplarList=new SorularDao().rastgele3YanlissoruGetir(vt,this,dogruSoru.getSoru_id());

        textViewSoruTurkce.setText(dogruSoru.getSoru_turkce());
        secenekleriKaristirmaList.clear();
        secenekleriKaristirmaList.add(dogruSoru);
        secenekleriKaristirmaList.add(cevaplarList.get(0));
        secenekleriKaristirmaList.add(cevaplarList.get(1));
        secenekleriKaristirmaList.add(cevaplarList.get(2));
        seceneklerListe.clear();
        for(Sorular s:secenekleriKaristirmaList){
            seceneklerListe.add(s);
        }
        btnFiil1.setText(seceneklerListe.get(0).getSoru_fransizca());
        btnIsim1.setText(seceneklerListe.get(1).getSoru_fransizca());
        btnSifat1.setText(seceneklerListe.get(2).getSoru_fransizca());
        btnZamir1.setText(seceneklerListe.get(3).getSoru_fransizca()); */

    } /*
     public void dogruKontrol(Button button){
        String buttonYazi=button.getText().toString();
        String dogruCevap=dogruSoru.getSoru_fransizca();

        if (buttonYazi.equals(dogruCevap)) {
            dogruSayac++;
            Toast.makeText(this,"Tebrikler",Toast.LENGTH_SHORT).show();

        }else{
            yanlisSayac++;
            Toast.makeText(this,"Malesef yanlış\n Doğru cevap:\n"+dogruCevap,Toast.LENGTH_LONG).show();
        }
        //textViewDogru.setText("Doğru: "+dogruSayac);
        //textViewYanlis.setText("Yanlış: "+yanlisSayac);


    }
    public void sayacKontrol() {
        soruSayac++;

        if (soruSayac != 10) {
            soruYukle();

        } else {
            Intent intent = new Intent(AlistirmaActivity.this, UyeOlActivity.class);
            intent.putExtra("dogruSayac", dogruSayac);
            startActivity(intent);
            finish();

        }
    }  */
}