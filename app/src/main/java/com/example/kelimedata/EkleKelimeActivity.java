package com.example.kelimedata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class EkleKelimeActivity extends AppCompatActivity {
    private EditText editTextTurkce,editTextFransizca,editTextTuru,editTextCinsiyeti,editTextResmi;

    private  String turkce,fransizca,turu,cinsiyeti,resmi;

    private Button btnKaydet,btnCumleKaydet,btnSoruKaydet,btnQuizEkle;
    private Database vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle_kelime);

        editTextTurkce=(EditText)findViewById(R.id.editText_Turkce);
        editTextFransizca=(EditText)findViewById(R.id.editText_Fransizca);
        editTextTuru=(EditText)findViewById(R.id.editText_Turu);
        editTextCinsiyeti=(EditText)findViewById(R.id.editText_Cinsiyeti);
        editTextResmi=(EditText)findViewById(R.id.editTextResmi);

        btnKaydet=(Button)findViewById(R.id.btnKelimeKaydet);
        btnCumleKaydet=(Button)findViewById(R.id.btnKaydet2);
        btnQuizEkle=(Button)findViewById(R.id.btnQuizEkle);
        vt=new Database(this);
        btnCumleKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertGoster();
            }
        });
        btnSoruKaydet=(Button)findViewById(R.id.btnKaydet3);
        btnSoruKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   alertGoster2();
                startActivity(new Intent(EkleKelimeActivity.this,AyrintiActivity.class));
            }
        });


        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               turkce=editTextTurkce.getText().toString().trim();
               fransizca=editTextFransizca.getText().toString().trim();
               turu=editTextTuru.getText().toString().trim();
               cinsiyeti=editTextCinsiyeti.getText().toString().trim();
               resmi=editTextResmi.getText().toString().trim();

              try {
                  if(TextUtils.isEmpty(turkce)){
                      Snackbar.make(v,"Türkçe kelime giriniz",Snackbar.LENGTH_SHORT).show();
                  }
                  if(TextUtils.isEmpty(fransizca)){
                      Snackbar.make(v,"Fransizca kelime giriniz",Snackbar.LENGTH_SHORT).show();
                      return;
                  }
                  if(TextUtils.isEmpty(turu)){
                      Snackbar.make(v," Kelime türü(örn:İsim,fiil vb.) giriniz",Snackbar.LENGTH_SHORT).show();
                      return;
                  }
                  if(TextUtils.isEmpty(cinsiyeti)){
                      Snackbar.make(v," Kelime cinsiyetini (la/le) giriniz",Snackbar.LENGTH_SHORT).show();
                      return;
                  }
                  new KelimelerDao().kelimeEkle(vt,turkce,fransizca,turu,cinsiyeti,resmi);
                  Toast.makeText(getApplicationContext(),"Kayıt başarılı",Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(EkleKelimeActivity.this,SozlukActivity.class));
                //  finish();
              }catch (Exception e)
              {
                  e.printStackTrace();
              }
            }
        });
        btnQuizEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EkleKelimeActivity.this,QuizEkleActivity.class));
            }
        });

    }



    public void alertGoster(){
        LayoutInflater layout=LayoutInflater.from(this);
        View tasarim=layout.inflate(R.layout.alert_tasarim,null);

        EditText editTextCumle_Turkce=tasarim.findViewById(R.id.editText_Turkce);
        EditText editTextCumle_Fransizca=tasarim.findViewById(R.id.editText_Fransizca);
        EditText editTextCumle_Resmi=tasarim.findViewById(R.id.editText_Turu);

        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Cümle ekle");
        ad.setView(tasarim);
        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String cumle_turkce=editTextCumle_Turkce.getText().toString().trim();
                String cumle_fransizca=editTextCumle_Fransizca.getText().toString().trim();
                String cumle_resmi=editTextCumle_Resmi.getText().toString().trim();

                Toast.makeText(getApplicationContext(),cumle_turkce+"\n"+cumle_fransizca+"\n",Toast.LENGTH_SHORT).show();

            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }
    public void alertGoster2(){
        LayoutInflater layout=LayoutInflater.from(this);
        View tasarim=layout.inflate(R.layout.alert_soruekle,null);

        EditText editTextSoru_Turkce=tasarim.findViewById(R.id.editTextSoru_Turkce);
        EditText editTextSoru_Fransizca=tasarim.findViewById(R.id.editTextSoru_Fransizca);
        EditText editTextSoru_Resmi=tasarim.findViewById(R.id.editTextSoru_Resmi);

        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Soru ekle");
        ad.setView(tasarim);
        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String soru_turkce=editTextSoru_Turkce.getText().toString().trim();
                String soru_fransizca=editTextSoru_Fransizca.getText().toString().trim();
                String soru_resmi=editTextSoru_Resmi.getText().toString().trim();

                Toast.makeText(getApplicationContext(),soru_turkce+"\n"+soru_fransizca+"\n",Toast.LENGTH_SHORT).show();

            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}