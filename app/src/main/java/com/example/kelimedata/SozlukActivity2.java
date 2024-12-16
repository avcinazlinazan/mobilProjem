package com.example.kelimedata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SozlukActivity2 extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView rvS;
    private ArrayList<Kelimeler> kelimelerArrayList;
    private SozlukAdapter adapter;
    private Database vt;
    private FloatingActionButton fabKapat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sozluk2);
        vt=new Database(this);


        rvS=findViewById(R.id.rvS);
        //rvS.hasFixedSize(true);
        rvS.setLayoutManager(new LinearLayoutManager(this));

        kelimelerArrayList=new ArrayList<>();
        kelimelerArrayList=new Sozlukdao().kelimeGetir(vt,this);
        adapter=new SozlukAdapter(this,kelimelerArrayList);
        rvS.setAdapter(adapter);
        fabKapat=findViewById(R.id.fabKapat);
        fabKapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SozlukActivity2.this,ContentActivity.class));
                finish();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sozluk_menu,menu);
        MenuItem item=menu.findItem(R.id.ara);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        aramaYap(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        aramaYap(newText);
        return false;
    }

    public void aramaYap(String arananKelime){
        kelimelerArrayList=new Sozlukdao().kelimeAra(vt,this,arananKelime);
        adapter=new SozlukAdapter(this,kelimelerArrayList);
        rvS.setAdapter(adapter);
    }



}