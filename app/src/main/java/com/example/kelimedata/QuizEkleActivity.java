package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class QuizEkleActivity extends AppCompatActivity {
    private EditText editTextQuizTurkce,editTextQuizFransizca,editTextQuizResmi;
    private Button buttonEkle;
    private  String turkce,fransizca,resmi;
    private Database vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_ekle);
        vt=new Database(this);

        editTextQuizTurkce=(EditText) findViewById(R.id.editTextQuizTurkce);
        editTextQuizFransizca=(EditText) findViewById(R.id.editTextQuizFransizca);
        editTextQuizResmi=(EditText) findViewById(R.id.editTextQuizResmi);
        buttonEkle=(Button)findViewById(R.id.buttonQuizEkle);
        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                turkce=editTextQuizTurkce.getText().toString().trim();
                fransizca=editTextQuizFransizca.getText().toString().trim();
                resmi=editTextQuizResmi.getText().toString().trim();

                try {
                    if(TextUtils.isEmpty(turkce)){
                        Snackbar.make(v,"Türkçe kelime giriniz",Snackbar.LENGTH_SHORT).show();
                    }
                    if(TextUtils.isEmpty(fransizca)){
                        Snackbar.make(v,"Fransizca kelime giriniz",Snackbar.LENGTH_SHORT).show();
                        return;
                    }

                    new QuizDao().quizEkle(vt,turkce,fransizca,resmi);
                    Toast.makeText(getApplicationContext(),"Kayıt başarılı",Toast.LENGTH_SHORT).show();

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });


    }


}