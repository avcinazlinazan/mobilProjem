package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class UyeOlActivity extends AppCompatActivity {
    private TextView textViewSonuc,textViewBasari;
    private int dogruSayac;
    private ProgressBar pB;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ol);
        textViewSonuc=(TextView)findViewById(R.id.textViewSonuc);
        textViewBasari=(TextView)findViewById(R.id.textViewBasari);
        dogruSayac=getIntent().getIntExtra("dogruSayac",0);
        textViewSonuc.setText(dogruSayac+ " DOĞRU "+(10-dogruSayac)+" YANLIŞ");
        textViewBasari.setText("% "+(dogruSayac*100)/10+" Başarı");
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UyeOlActivity.this,ContentActivity.class);
                startActivity(intent);
            }
        });

    }
}