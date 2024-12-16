package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnKayit;
    private ImageView imageViewH;
    Animation anim;
    long ANIMATION_DURATION = 300;
 /*   Button btnVeri,btnKelimeEsleme;   */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewH = (ImageView) findViewById( R.id.imageViewH );
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animasyon); // Create the animation.
        imageViewH.startAnimation(anim);
    /*    btnVeri=(Button)findViewById(R.id.button);
        btnKelimeEsleme=(Button)findViewById(R.id.button2);
        btnVeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,VerilerActivity.class);
                startActivity(intent);
            }
        });
        btnKelimeEsleme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CumleEkleActivity.class);
                startActivity(intent);
            }
        });  */


        btnLogin=findViewById(R.id.btn_girisyap);
        btnKayit=findViewById(R.id.btn_kayitol);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();


            }
        });
        btnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(MainActivity.this,SozlukActivity.class));
            }
        });
    }
}