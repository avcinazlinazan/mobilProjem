package com.example.kelimedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class AyrintiActivity extends AppCompatActivity {
    private EditText editTextTurkce,editTextFransizca,editTextResmi;
    private Button buttonSoru;
    private  String soru_turkce,soru_fransizca,soru_resmi;
    private Database vt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayrinti);

        editTextTurkce=(EditText)findViewById(R.id.editTextSoruTurkce);
        editTextFransizca=(EditText)findViewById(R.id.editTextFransizcaSoru);
        editTextResmi=(EditText)findViewById(R.id.editTextSoruResmi);
        buttonSoru=(Button)findViewById(R.id.buttonSoru);
        vt=new Database(this);
        buttonSoru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soru_turkce=editTextTurkce.getText().toString().trim();
                soru_fransizca=editTextFransizca.getText().toString().trim();


                soru_resmi=editTextResmi.getText().toString().trim();

                try {
                    if(TextUtils.isEmpty(soru_turkce)){
                        Snackbar.make(v,"Türkçe soru giriniz",Snackbar.LENGTH_SHORT).show();
                        return;
                    }
                    if(TextUtils.isEmpty(soru_fransizca)){
                        Snackbar.make(v,"Fransizca soru giriniz",Snackbar.LENGTH_SHORT).show();
                        return;
                    }
                    new SorularDao().soruEkle(vt,soru_turkce,soru_fransizca,soru_resmi);


                    Toast.makeText(getApplicationContext(),"Kayıt başarılı",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AyrintiActivity.this,SozlukActivity.class));

                    finish();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.genel_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sil:
                Snackbar.make(editTextFransizca,"Silinsin mi?",Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(AyrintiActivity.this,SozlukActivity.class));
                        finish();

                    }
                }).show();
                return true;
            case R.id.duzenle:
                startActivity(new Intent(AyrintiActivity.this,SozlukActivity.class));
                finish();
                return true;
            default:
                return false;
        }

    }
}