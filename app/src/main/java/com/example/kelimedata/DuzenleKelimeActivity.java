package com.example.kelimedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class DuzenleKelimeActivity extends AppCompatActivity {
    private EditText editTextTurkce,editTextFransizca,editTextTuru,editTextCinsiyeti,editTextResmi;
    private  String turkce,fransizca,turu,cinsiyeti,resmi;
    private Database vt;
    private Kelimeler kelimeler;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duzenle_kelime);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Güncelle");
        setSupportActionBar(toolbar);


        editTextTurkce=(EditText)findViewById(R.id.editText_Turkce);
        editTextFransizca=(EditText)findViewById(R.id.editText_Fransizca);
        editTextTuru=(EditText)findViewById(R.id.editText_Turu);
        editTextCinsiyeti=(EditText)findViewById(R.id.editText_Cinsiyeti);
        editTextResmi=(EditText)findViewById(R.id.editTextResmi);
        vt=new Database(this);
        kelimeler=(Kelimeler)getIntent().getSerializableExtra("kelime_nesne");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.genel_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sozluk:
                startActivity(new Intent(DuzenleKelimeActivity.this,SozlukActivity.class));
                return true;
            case R.id.sil:
                Snackbar.make(editTextTurkce,"Silinsin mi?",Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new KelimelerDao().kelimeSil(vt,kelimeler.getKelime_id());
                        startActivity(new Intent(DuzenleKelimeActivity.this,SozlukActivity.class));
                        finish();
                    }
                }).show();
                return true;
            case R.id.duzenle:

                turkce=editTextTurkce.getText().toString().trim();
                fransizca=editTextFransizca.getText().toString().trim();
                turu=editTextTuru.getText().toString().trim();
                cinsiyeti=editTextCinsiyeti.getText().toString().trim();
                resmi=editTextResmi.getText().toString().trim();

                try {
                    if(TextUtils.isEmpty(turkce)){
                        Snackbar.make(toolbar,"Türkçe kelime giriniz",Snackbar.LENGTH_SHORT).show();
                    }
                    if(TextUtils.isEmpty(fransizca)){
                        Snackbar.make(toolbar,"Fransizca kelime giriniz",Snackbar.LENGTH_SHORT).show();
                        return false;
                    }
                    if(TextUtils.isEmpty(turkce)){
                        Snackbar.make(toolbar," Kelime türü(örn:İsim,fiil vb.) giriniz",Snackbar.LENGTH_SHORT).show();
                        return false;
                    }
                    if(TextUtils.isEmpty(cinsiyeti)){
                        Snackbar.make(toolbar," Kelime cinsiyetini (la/le) giriniz",Snackbar.LENGTH_SHORT).show();
                        return false;
                    }
                    new KelimelerDao().kelimeDuzenle(vt,kelimeler.getKelime_id(),turkce,fransizca,turu,cinsiyeti,resmi);
                    Toast.makeText(getApplicationContext(),"Kayıt güncellendi",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DuzenleKelimeActivity.this,SozlukActivity.class));
                    finish();
                    return true;
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            default:
                return false;
        }

    }
}