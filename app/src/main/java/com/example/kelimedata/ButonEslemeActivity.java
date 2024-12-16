package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ButonEslemeActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton img1,img2,img3,img4,img5,img6,img7,img8;
    TableLayout tableLayout;
    int counter = 0;
    TextView k_bilgiler,e_text;
    long beginTime = 0, endTime = 0;
    boolean b1 = false,b2= false,b3= false,b4= false,b5= false,b6= false,b7= false,b8= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buton_esleme);

        k_bilgiler = (TextView)findViewById( R.id.bilgiler );
        String deger1 = getIntent().getStringExtra( "name" );
        k_bilgiler.setText("Kullanıcı" + " " +deger1 );
        e_text = (TextView)findViewById( R.id.textView6 );
        img1 =(ImageButton)findViewById( R.id.imageButton );
        img2 =(ImageButton)findViewById( R.id.imageButton3 );
        img3 =(ImageButton)findViewById( R.id.imageButton4 );
        img4 =(ImageButton)findViewById( R.id.imageButton5 );
        img5 =(ImageButton)findViewById( R.id.imageButton6 );
        img6 =(ImageButton)findViewById( R.id.imageButton7 );
        img7 =(ImageButton)findViewById( R.id.imageButton8 );
        img8 =(ImageButton)findViewById( R.id.imageButton9 );
        tableLayout =(TableLayout)findViewById( R.id.tablelayout );
        beginTime = System.nanoTime();
    }

    public void Son ()
    {
        if(b1 == true && b2 == true && b3 == true && b4 == true && b5 == true && b6 == true && b7 == true && b8 == true)
        {
            endTime =System.nanoTime();
            tableLayout.setVisibility( View.INVISIBLE );
            double time = (double)(endTime-beginTime)/1000000000;
            e_text.setText( " Geçen Süre" + String.valueOf(String.format("%10.0f", time))  );
            e_text.setVisibility( View.VISIBLE );

        }
    }
    @Override
    public void onClick(View v) {

        counter++;
        switch (v.getId()) {
            case R.id.imageButton:

                img1.setBackgroundResource( R.color.kirmizi );
                b1 = true;
                break;

            case R.id.imageButton3:

                img2.setBackgroundResource( R.color.pembe );
                b2 = true;
                break;

            case R.id.imageButton4:

                img3.setBackgroundResource( R.color.kirmizi );
                b3 = true;
                break;

            case R.id.imageButton5:

                img4.setBackgroundResource( R.color.yellow );
                b4 = true;
                break;

            case R.id.imageButton6:

                img5.setBackgroundResource( R.color.pembe );

                b5 = true;
                break;
            case R.id.imageButton7:

                img6.setBackgroundResource( R.color.black );

                b6 = true;
                break;
            case R.id.imageButton8:

                img7.setBackgroundResource( R.color.yellow );

                b7 = true;
                break;
            case R.id.imageButton9:

                img8.setBackgroundResource( R.color.black);

                b8 = true;
                break;
        }

        if (counter == 2) {
            new CountDownTimer(2000, 1000){
                public void onTick(long millisUntilFinished){

                }
                public  void onFinish(){
                    Kontrol();
                }
            }.start();
        }

    }
    public void Kontrol()
    {

        if(b1 == true && b3 == true)
        {
            img1.setVisibility( View.INVISIBLE );
            img3.setVisibility( View.INVISIBLE );
            Toast.makeText(getApplicationContext(),"  Kırmızı -Rouge",Toast.LENGTH_SHORT).show();

        }
        else
        {
            img1.setBackgroundResource( R.drawable.pasif);
            img3.setBackgroundResource( R.drawable.pasif);
            b1=false;
            b3=false;
        }

        if(b2 == true && b5 == true)
        {
            img2.setVisibility( View.INVISIBLE );
            img5.setVisibility( View.INVISIBLE );
            Toast.makeText(getApplicationContext(),"Pembe - Rose",Toast.LENGTH_SHORT).show();


        }
        else
        {
            img2.setBackgroundResource( R.drawable.pasif);
            img5.setBackgroundResource( R.drawable.pasif);
            b2=false;
            b5=false;
        }
        if(b4 == true && b7 == true)
        {
            img4.setVisibility( View.INVISIBLE );
            img7.setVisibility( View.INVISIBLE );
            Toast.makeText(getApplicationContext(),"Sarı - Joune",Toast.LENGTH_SHORT).show();
        }
        else
        {
            img4.setBackgroundResource( R.drawable.pasif);
            img7.setBackgroundResource( R.drawable.pasif);
            b4=false;
            b7=false;
        }
        if(b6 == true && b8 == true)
        {
            img6.setVisibility( View.INVISIBLE );
            img8.setVisibility( View.INVISIBLE );
            Toast.makeText(getApplicationContext(),"Siyah -Noire",Toast.LENGTH_SHORT).show();
        }
        else
        {
            img6.setBackgroundResource( R.drawable.pasif);
            img8.setBackgroundResource( R.drawable.pasif);
            b6=false;
            b8=false;
        }
        counter =0;

        Son();

    }
}