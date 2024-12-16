package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class KelimeEslemeActivity extends AppCompatActivity implements View.OnDragListener,View.OnLongClickListener {
    private TextView textViewDogru, textViewYanlis, textViewSoruSayisi;
    private Button buttonA, buttonB, buttonC, buttonD;
    private ImageView imageSoruResmi;

    private ProgressBar pr;
    private ArrayList<Sorular> sorularList;
    private ArrayList<Sorular> yanlisSeceneklerList;
    private Sorular dogruSoru;
    private Database vt;
    //sayaçlar
    private int soruSayac = 0;
    private int yanlisSayac = 0;
    private int dogruSayac = 0;
    //secenekler
    private HashSet<Sorular> secenekleriKaristirmaList = new HashSet<>();
    private ArrayList<Sorular> seceneklerListe = new ArrayList<>();


    private TextView textSoru;
    private ImageView imageCevap1, imageCevap2, imageCevap3, imageCevap4;
    private LinearLayout soruL, cevap1L, cevap2L, cevap3L, cevap4L;


    private static final String YAZI_ETIKET = "YAZI";
    private static final String RESIM1_ETIKET = "RESIM1";
    private static final String RESIM2_ETIKET = "RESIM2";
    private static final String RESIM3_ETIKET = "RESIM3";
    private static final String RESIM4_ETIKET = "RESIM4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_esleme);

        soruL = findViewById(R.id.soruL);
        cevap1L = findViewById(R.id.cevap1L);
        cevap2L = findViewById(R.id.cevap2L);
        cevap3L = findViewById(R.id.cevap3L);
        cevap4L = findViewById(R.id.cevap4L);

        textSoru = (TextView) findViewById(R.id.textSoru);
        textSoru.setTag(YAZI_ETIKET);
        imageCevap1 = (ImageView) findViewById(R.id.imageCevap1);
        imageCevap1.setTag(RESIM1_ETIKET);
        imageCevap2 = (ImageView) findViewById(R.id.imageCevap2);
        imageCevap2.setTag(RESIM2_ETIKET);
        imageCevap3 = (ImageView) findViewById(R.id.imageCevap3);
        imageCevap3.setTag(RESIM3_ETIKET);
        imageCevap4 = (ImageView) findViewById(R.id.imageCevap4);
        imageCevap4.setTag(RESIM4_ETIKET);

        textSoru.setOnLongClickListener(this);
        imageCevap1.setOnLongClickListener(this);
        imageCevap2.setOnLongClickListener(this);
        imageCevap3.setOnLongClickListener(this);
        imageCevap4.setOnLongClickListener(this);

        soruL.setOnDragListener(this);
        cevap1L.setOnDragListener(this);
        cevap2L.setOnDragListener(this);
        cevap3L.setOnDragListener(this);
        cevap4L.setOnDragListener(this);

        textViewDogru = (TextView) findViewById(R.id.textViewDogru);
        textViewYanlis = (TextView) findViewById(R.id.textViewYanlis);
        textViewSoruSayisi = (TextView) findViewById(R.id.textViewSoruSayisi);

        imageSoruResmi = (ImageView) findViewById(R.id.imageSoruResmi);
        imageCevap1 = (ImageView) findViewById(R.id.imageCevap1);
        imageCevap2 = (ImageView) findViewById(R.id.imageCevap2);
        imageCevap3 = (ImageView) findViewById(R.id.imageCevap3);
        imageCevap4 = (ImageView) findViewById(R.id.imageCevap4);
        vt = new Database(this);
        sorularList = new SorularDao().rastgele1soruGetir(vt, this);
        soruYukle();



/*
        imageCevap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonA);
                sayacKontrol();


            }
        });
        imageCevap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonB);
                sayacKontrol();


            }
        });
        imageCevap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonC);
                sayacKontrol();



            }
        });
        imageCevap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogruKontrol(buttonD);
                sayacKontrol();


            }
        });  */


    }

    @Override
    public boolean onLongClick(View view) {
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
        String[] mineType = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData clipData = new ClipData(view.getTag().toString(), mineType, item);
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(clipData, shadowBuilder, view, 0);
        view.setVisibility(View.INVISIBLE);
        return true;
    }

    @Override
    public boolean onDrag(View view, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                return true;
            case DragEvent.ACTION_DRAG_ENTERED:
                view.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                view.invalidate();
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                view.getBackground().clearColorFilter();
                view.invalidate();
                return true;
            case DragEvent.ACTION_DROP:

                View gorselNesne = (View) event.getLocalState();
                ViewGroup eskiTasarimAlani = (ViewGroup) gorselNesne.getParent();
                eskiTasarimAlani.removeView(gorselNesne);
                LinearLayout hedefTasarimAlani = (LinearLayout) view;
                hedefTasarimAlani.addView(gorselNesne);
                gorselNesne.setVisibility(View.VISIBLE);

                //  view.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                //  view.invalidate();

                view.getBackground().clearColorFilter();
                view.invalidate();

                return true;
            case DragEvent.ACTION_DRAG_ENDED:

             boolean x = dogruKontrol();

                if (x) {
                    view.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                    view.invalidate();

                } else {
                    view.getBackground().clearColorFilter();
                    view.invalidate();
                    Toast.makeText(this, "Malesef yanlış" ,Toast.LENGTH_LONG).show();
                }

                sayacKontrol();
                    return true;







                // view.getBackground().clearColorFilter();
                //view.invalidate();
         //      return true;
            default:
                break;
        }
        return false;
    }

    public void soruYukle() {
      //  textViewSoruSayisi.setText((soruSayac + 1) + ".SORU");
        textViewDogru.setText("Doğru: " + dogruSayac);
        textViewYanlis.setText("Yanlış: " + yanlisSayac);

        dogruSoru = sorularList.get(0);
        yanlisSeceneklerList = new SorularDao().rastgele3YanlissoruGetir(vt, this, dogruSoru.getSoru_id());

        textSoru.setText(dogruSoru.getSoru_fransizca());
        //imageCevap4.setImageResource(getResources().getIdentifier(dogruSoru.getSoru_resmi(),"drawable",getPackageName()));
        secenekleriKaristirmaList.clear();
        secenekleriKaristirmaList.add(dogruSoru);
        secenekleriKaristirmaList.add(yanlisSeceneklerList.get(0));
        secenekleriKaristirmaList.add(yanlisSeceneklerList.get(1));
        secenekleriKaristirmaList.add(yanlisSeceneklerList.get(2));
        seceneklerListe.clear();
        for (Sorular s : secenekleriKaristirmaList) {
            seceneklerListe.add(s);
        }
        imageCevap1.setImageResource(getResources().getIdentifier(seceneklerListe.get(0).getSoru_resmi(), "drawable", getPackageName()));
        imageCevap2.setImageResource(getResources().getIdentifier(seceneklerListe.get(1).getSoru_resmi(), "drawable", getPackageName()));
        imageCevap3.setImageResource(getResources().getIdentifier(seceneklerListe.get(2).getSoru_resmi(), "drawable", getPackageName()));
        imageCevap4.setImageResource(getResources().getIdentifier(seceneklerListe.get(3).getSoru_resmi(), "drawable", getPackageName()));
    }

    public boolean dogruKontrol() {
        String imgYol = "";
        String dogruCevap = dogruSoru.getSoru_resmi();

        for (int i = 0; i < 3; i++) {
            imgYol = seceneklerListe.get(i).getSoru_resmi().toString();
        }

        if (imgYol.equals(dogruCevap)) {
            dogruSayac++;
           Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show();
            return true;

        } else {
            yanlisSayac++;
            Toast.makeText(this, "Malesef yanlış" + dogruCevap, Toast.LENGTH_LONG).show();
            return false;

        }
    }


        public void sayacKontrol(){
          soruSayac++;
            if (soruSayac != 1) {
                soruYukle();

            } else {
               Intent intent = new Intent(KelimeEslemeActivity.this, ContentActivity.class);

              startActivity(intent);
             finish();
            }
        }

    }