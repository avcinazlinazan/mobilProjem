package com.example.kelimedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class VerilerActivity extends AppCompatActivity {
    private Toolbar toolbar1;
    private RecyclerView mrecyclerView;
    private KelimeAdapter adapter;
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }  */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.genel_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
          /*  case R.id.arama:
                Intent intent1 = new Intent(VerilerActivity.this,KelimeEkleActivity.class);
                startActivity(intent1);
                break; */

            case R.id.sozluk:
                Intent intent2 = new Intent(VerilerActivity.this,KelimeEslemeActivity.class);
                startActivity(intent2);
                break;
            case R.id.alfabe:
                Intent intent3 = new Intent(VerilerActivity.this,UyeOlActivity.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add_menu_add_kelime){
            Intent intent=new Intent(VerilerActivity.this,KelimeEkleActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }  */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veriler);
       toolbar1=findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar1);

        mrecyclerView=(RecyclerView)findViewById(R.id.rv);
        adapter=new KelimeAdapter(Kelime.getData(this),this);

        mrecyclerView.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mrecyclerView.setLayoutManager(manager);
        mrecyclerView.setAdapter(adapter);
    }
}