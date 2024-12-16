package com.example.kelimedata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SozlukActivity extends AppCompatActivity {
    private RecyclerView rvSozluk;
    private ArrayList<Kelimeler> kelimelerArrayList;
    private KelimelerAdapter adapter;
    private FloatingActionButton fab,  fabKapat2;
    private Database vt;
    private Kelimeler kelimeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sozluk);
        rvSozluk=(RecyclerView)findViewById(R.id.rvSozluk);
        vt=new Database(this);
        kelimeler=(Kelimeler)getIntent().getSerializableExtra("kelime_nesne");

        rvSozluk.setHasFixedSize(true);
        rvSozluk.setLayoutManager(new LinearLayoutManager(this));
        
        kelimelerArrayList =new Sozlukdao().kelimeGetir(vt,this);

        adapter=new KelimelerAdapter(this,kelimelerArrayList);
        rvSozluk.setAdapter(adapter);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SozlukActivity.this,EkleKelimeActivity.class));

            }
        });
        fabKapat2=findViewById(R.id.fabKapat2);
        fabKapat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SozlukActivity.this,ContentActivity.class));
                finish();

            }
        });
    }



}