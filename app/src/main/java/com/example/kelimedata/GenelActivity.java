package com.example.kelimedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class GenelActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){


            case R.id.alfabe:
                alertGosterAlfabe();
                break;
            case R.id.kapat:
                finish();
                break;
            case R.id.sayilar:
                alertGosterSayilar();
                break;
            case R.id.renkler:
                alertGosterRenkler();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ListView mListView;
    private String[] konular={"Tanışma ve Selamlaşma","Mevsimler","Alış-veriş","Aile","Renkler","Seyahat","Yemekler","Yol Tarifi","Burclar","Zaman ve sayılar"};
    private String[] fransizcaKonular={"Réunion et Salutation","Saisons","Achats","Famille","Couleurs","Voyage", "Repas", "Directions","Horoscope","Temps et nombres"};
    private int[] resimler = {R.drawable.tanisma,R.drawable.mevsimler,R.drawable.alisveris,R.drawable.aile,R.drawable.renkler,R.drawable.seyehat_doga,R.drawable.yemek,R.drawable.yol_tarifi,R.drawable.burclar,R.drawable.zaman};
    private String[] cumle1={"Salut Thomas.\n Comment ça va?","","","","","","","","",""};
    private String[] cumle2={"Salut...\nÇa va et toi?","","","","","","","","",""};
    private String[] cumle3={"Ça va... \nVoici Maria. \nElle est espognole","","","","","","","","","Il est dix heures neuf\n [Saat 10'u 9 geçiyor]"};
    private String[] cumle4={"Vous étes espagnol?","","","","","","","","","Il est sept heures moins cink\n [Saat 7'u 5 geçiyor]"};
    private String[] cumle5={"Thomas Dupre...\nBonjour!","","","","","","","",""," Quelle heure est-il?\n [Saat kaç?]\nIl est huit heures\n[saat sekiz]"};
    private String[] cumle6={"-et Ines. Tu es espagnol aussi\n-Non. Je suis française","","","","","","","","","","Ah.Enfin!. Vous êtes là! [Ah. Nihayet. Oradasın!]"};
    private String[] cumle7={"Vous vous applez comment?","","","","","","","","","Je suis en retard?\n [Geç mi kaldım]"};
    private String[] cumle8={"Je m'appelle Thomas","","","","","","","","","","Votre spectacle commence à onze heures et demie!\n[Senin gösterin 11 buçukta başlıyor] "};
    private String[] cumle9={"Tu t'appelles comment?","","","","","","","","","Et quelle heure est-il?\nMinuit moins vingt.\n[ve saat kaç? -gece yarısına 20 var]\nLe publick attend[Halk bekliyor]"};
    private String[] cumle10={"Je m'appelle Maria\nEnchanté","","","","","","","","","On attend toujours les stars\n[Starlar hep beklenir]"};
    private String[] cumle_7={"Adınız Ne?","","","","","","","","","Je suis en retard?\n [Geç mi kaldım]"};
    private String[] cumle_8={"Benim adım Thomas","","","","","","","","","","Votre spectacle commence à onze heures et demie!\n[Senin gösterin 11 buçukta başlıyor] "};
    private String[] cumle_9={"Senin adın ne?","","","","","","","","","Et quelle heure est-il?\nMinuit moins vingt.\n[ve saat kaç? -gece yarısına 20 var]\nLe publick attend[Halk bekliyor]"};
    private String[] cumle_10={"Adım Maria\nMemnun oldum","","","","","","","","","On attend toujours les stars\n[Starlar hep beklenir]"};
    private MenuAdapter adapter;
    private Intent detailsIntent;
    static public cumle cumle;
    private Bitmap resim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genel);

        mListView=(ListView)findViewById(R.id.mlistView);
        adapter=new MenuAdapter(konular,fransizcaKonular,resimler,this);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i<10){
                    detailsIntent=new Intent(GenelActivity.this,DetayActivity.class);
                    resim= BitmapFactory.decodeResource(getApplicationContext().getResources(),resimler[i]);

                    cumle=new cumle(konular[i],fransizcaKonular[i],cumle1[i],cumle2[i],cumle3[i],cumle4[i],cumle5[i],cumle6[i],cumle7[i],cumle8[i],cumle9[i],cumle10[i],cumle_7[i],cumle_8[i],cumle_9[i],cumle_10[i],resim);

                    startActivity(detailsIntent);

                }

            }
        });
    }

    public void alertGosterAlfabe(){
        LayoutInflater layout=LayoutInflater.from(this);
        View tasarim=layout.inflate(R.layout.alert_alfabe,null);


        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Alfabe");
        ad.setView(tasarim);
        ad.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"Alfabede harflerin okunuşunu öğrendiniz",Toast.LENGTH_SHORT).show();

            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }

    public void alertGosterRenkler(){
        LayoutInflater layout=LayoutInflater.from(this);
        View tasarim=layout.inflate(R.layout.alert_renkler,null);


        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Renkler");
        ad.setView(tasarim);
        ad.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"Fransızca Renkleri öğrendiniz",Toast.LENGTH_SHORT).show();

            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }
    public void alertGosterSayilar(){
        LayoutInflater layout=LayoutInflater.from(this);
        View tasarim=layout.inflate(R.layout.alert_sayilar,null);


        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Sayılar");
        ad.setView(tasarim);
        ad.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"Fransızca sayıların okunuşunu öğrendiniz",Toast.LENGTH_SHORT).show();

            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }

}