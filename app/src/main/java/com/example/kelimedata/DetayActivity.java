package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private TextView txtBaslik,txtBaslik2,txtCumle1,txtCumle2,txtCumle3,txtCumle4,txtCumle5,txtCumle6,txtCumle7,txtCumle8,txtCumle9,txtCumle10,txtCumle_7,txtCumle_8,txtCumle_9,txtCumle_10;
    private ImageView imageViewResmi;

    private String Baslik,Baslik2,Cumle1,Cumle2,Cumle3,Cumle4,Cumle5,Cumle6,Cumle7,Cumle8,Cumle9,Cumle10,Cumle_7,Cumle_8,Cumle_9,Cumle_10;
    private Bitmap secilenResim;
    Animation anim,anim_alt,anim_ust,anim_left,anim_left1,anim_right8,anim_left9,anim_right10,anim_right2;
    long ANIMATION_DURATION = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        txtBaslik=(TextView)findViewById(R.id.textViewBaslik);
        txtBaslik2=(TextView)findViewById(R.id.textViewBaslik2);
        txtCumle1=(TextView)findViewById(R.id.textViewCumle1);
        txtCumle2=(TextView)findViewById(R.id.textViewCumle2);
        txtCumle3=(TextView)findViewById(R.id.textViewCumle3);
        txtCumle4=(TextView)findViewById(R.id.textViewCumle4);
        txtCumle5=(TextView)findViewById(R.id.textViewCumle5);
        txtCumle6=(TextView)findViewById(R.id.textViewCumle6);
        txtCumle7=(TextView)findViewById(R.id.textViewCumle7);
        txtCumle8=(TextView)findViewById(R.id.textViewCumle8);
        txtCumle9=(TextView)findViewById(R.id.textViewCumle9);
        txtCumle10=(TextView)findViewById(R.id.textViewCumle10);
        txtCumle_7=(TextView)findViewById(R.id.textViewCumle_7);
        txtCumle_8=(TextView)findViewById(R.id.textViewCumle_8);
        txtCumle_9=(TextView)findViewById(R.id.textViewCumle_9);
        txtCumle_10=(TextView)findViewById(R.id.textViewCumle_10);
        imageViewResmi=(ImageView)findViewById(R.id.imageViewKonuResmi);



        Baslik=GenelActivity.cumle.getBaslik1();
        Baslik2=GenelActivity.cumle.getBaslik2();
        Cumle1=GenelActivity.cumle.getCumle1();
        Cumle2=GenelActivity.cumle.getCumle2();
        Cumle3=GenelActivity.cumle.getCumle3();
        Cumle4=GenelActivity.cumle.getCumle4();
        Cumle5=GenelActivity.cumle.getCumle5();
        Cumle6=GenelActivity.cumle.getCumle6();
        Cumle7=GenelActivity.cumle.getCumle7();
        Cumle8=GenelActivity.cumle.getCumle8();
        Cumle9=GenelActivity.cumle.getCumle9();
        Cumle10=GenelActivity.cumle.getCumle10();
        Cumle_7=GenelActivity.cumle.getCumle_7();
        Cumle_8=GenelActivity.cumle.getCumle_8();
        Cumle_9=GenelActivity.cumle.getCumle_9();
        Cumle_10=GenelActivity.cumle.getCumle_10();
        secilenResim=GenelActivity.cumle.getResim();

        if(!TextUtils.isEmpty(Baslik) && !TextUtils.isEmpty(Baslik2)){
            txtBaslik.setText(Baslik);
            txtBaslik2.setText(Baslik2);
            txtCumle1.setText(Cumle1);
            txtCumle2.setText(Cumle2);
            txtCumle3.setText(Cumle3);
            txtCumle4.setText(Cumle4);
            txtCumle5.setText(Cumle5);
            txtCumle6.setText(Cumle6);
            txtCumle7.setText(Cumle7);
            txtCumle8.setText(Cumle8);
            txtCumle9.setText(Cumle9);
            txtCumle10.setText(Cumle10);
            txtCumle_7.setText(Cumle_7);
            txtCumle_8.setText(Cumle_8);
            txtCumle_9.setText(Cumle_9);
            txtCumle_10.setText(Cumle_10);

            imageViewResmi.setImageBitmap(secilenResim);


        }
        if(!TextUtils.isEmpty(Baslik)){
            anim_left= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_left); // Create the animation.
            txtCumle7.startAnimation(anim_left);
            txtCumle_7.startAnimation(anim_left);

            anim_right8= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_right8); // Create the animation.
            txtCumle8.startAnimation(anim_right8);
            txtCumle_8.startAnimation(anim_right8);

        }
        if(!TextUtils.isEmpty(Baslik2)){
            anim_left1= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_left1); // Create the animation.
            anim_right2= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_right2); // Create the animation.
            txtCumle1.startAnimation(anim_right2);
            txtCumle2.startAnimation(anim_right2);
            txtCumle3.startAnimation(anim_right2);
            txtCumle4.startAnimation(anim_right2);
            txtCumle5.startAnimation(anim_right2);
            txtCumle6.startAnimation(anim_right2);

        }





        anim_left9= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_left9); // Create the animation.
        txtCumle9.startAnimation(anim_left9);
        txtCumle_9.startAnimation(anim_left9);

        anim_right10= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_right10); // Create the animation.
        txtCumle10.startAnimation(anim_right10);
        txtCumle_10.startAnimation(anim_right10);
    }
}