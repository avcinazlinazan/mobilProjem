package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class KelimeyeCumleActivity extends AppCompatActivity {
    private RecyclerView rvCumle;
    private ArrayList<Cumleler> cumlelerArrayList;
    private CumleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimeye_cumle);
        rvCumle=findViewById(R.id.rvCumle);
        rvCumle.setHasFixedSize(true);
       // rvCumle.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        rvCumle.setLayoutManager(new LinearLayoutManager(this));
        cumlelerArrayList=new ArrayList<>();
        Cumleler c1=new Cumleler(1,"benim annem bir melek","ma mere est une angle","alisveris");
        cumlelerArrayList.add(c1);
        adapter=new CumleAdapter(this,cumlelerArrayList);
        rvCumle.setAdapter(adapter);
    }
}