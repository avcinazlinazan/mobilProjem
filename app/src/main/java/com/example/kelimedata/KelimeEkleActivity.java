package com.example.kelimedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KelimeEkleActivity extends AppCompatActivity {

    private EditText editTextTurkce,editTextFransizca,editTextTuru,editTextCinsiyeti,editTextCumleTurkce,editTextCumleFransizca;
    private ImageView imageViewResmi;
    private  String turkce,fransizca,turu,cinsiyeti,cumle,cumleF;
    private int imgIzinAlmaKodu=0,imgIzinVerildiKodu=1;
    Bitmap secilenResim,kucultulenResim,enBastakiResim;
    private Button btnKaydet;

    private  void init(){
        editTextTurkce=(EditText)findViewById(R.id.editText_Turkce);
        editTextFransizca=(EditText)findViewById(R.id.editText_Fransizca);
        editTextTuru=(EditText)findViewById(R.id.editText_Turu);
        editTextCinsiyeti=(EditText)findViewById(R.id.editText_Cinsiyeti);
        imageViewResmi=(ImageView)findViewById(R.id.kelimeResmi);
        btnKaydet=(Button)findViewById(R.id.btnKelimeKaydet);

        editTextCumleTurkce=(EditText)findViewById(R.id.editTextResmi);
        editTextCumleFransizca=(EditText)findViewById(R.id.editTextCumleFransizca);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_ekle);

        init();
    }
    public void KelimeKaydet(View v){
        turkce=editTextTurkce.getText().toString();
        fransizca=editTextFransizca.getText().toString();
        turu=editTextTuru.getText().toString();
        cinsiyeti=editTextCinsiyeti.getText().toString();
        cumle=editTextCumleTurkce.getText().toString();
        cumleF=editTextCumleFransizca.getText().toString();

        if(!TextUtils.isEmpty(turkce)){
            if(!TextUtils.isEmpty(fransizca)){
                if(!TextUtils.isEmpty(turu)){
                    if(!TextUtils.isEmpty(cinsiyeti)){
                        //kaydet
                        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
                        kucultulenResim = resimiKucult(secilenResim);
                        kucultulenResim.compress(Bitmap.CompressFormat.PNG,75,outputStream);
                        byte[] kayitEdilecekResim=outputStream.toByteArray();
                        try {
                         SQLiteDatabase database = this.openOrCreateDatabase("Kelimeler",MODE_PRIVATE,null);
                           database.execSQL("CREATE TABLE IF NOT EXISTS kelimeler (id INTEGER PRIMARY KEY,Turkce VARCHAR,Fransizca  VARCHAR,Turu  VARCHAR,Cinsiyeti  VARCHAR,Kelime_Resmi BLOB,Cumle VARCHAR,CumleF  VARCHAR)");



                            String sqlSorgusu="INSERT INTO kelimeler(Turkce, Fransizca,Turu,Cinsiyeti,Kelime_Resmi,Cumle,CumleF) VALUES(?,?,?,?,?,?,?)";

                            SQLiteStatement statement=database.compileStatement(sqlSorgusu);
                            statement.bindString(1,turkce);
                            statement.bindString(2,fransizca);
                            statement.bindString(3,turu);
                            statement.bindString(4,cinsiyeti);
                            statement.bindString(6,cumle);
                            statement.bindString(7,cumleF);
                            statement.bindBlob(5,kayitEdilecekResim);
                            statement.execute();
                            nesneleriTemizle();
                            showToast("Kayıt başarıyla eklendi");

                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }else
                        showToast("cinsiyeti boş olamaz");

                }else
                    showToast("türü boş olamaz");

            }else
               showToast("anlamı boş olamaz");
        }else
            showToast("kelime boş olamaz");
    }




    private Bitmap resimiKucult(Bitmap resim){
        return Bitmap.createScaledBitmap(resim,60,75,true);
    }

    private void showToast(String mesaj){
        Toast.makeText(getApplicationContext(),mesaj,Toast.LENGTH_SHORT).show();
    }





    private void nesneleriTemizle(){
        editTextTurkce.setText("");
        editTextFransizca.setText("");
        editTextCumleTurkce.setText("");
        editTextCumleFransizca.setText("");
        editTextTuru.setText("");
        editTextCinsiyeti.setText("");
        enBastakiResim= BitmapFactory.decodeResource(this.getResources(),R.drawable.resim);
        imageViewResmi.setImageBitmap(enBastakiResim);
        btnKaydet.setEnabled(false);
    }
    public void resimSec(View v){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},imgIzinAlmaKodu);
        }else {
            Intent resimAl=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(resimAl,imgIzinVerildiKodu);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == imgIzinAlmaKodu){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent resimAl=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(resimAl,imgIzinVerildiKodu);

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==imgIzinVerildiKodu){
            if(resultCode==RESULT_OK && data != null){
                Uri resimUri = data.getData();

                try {
                    if(Build.VERSION.SDK_INT >= 28){
                        ImageDecoder.Source  resimSource=ImageDecoder.createSource(this.getContentResolver(),resimUri);

                        secilenResim=ImageDecoder.decodeBitmap(resimSource);
                        imageViewResmi.setImageBitmap(secilenResim);

                    }else{
                        secilenResim = MediaStore.Images.Media.getBitmap(this.getContentResolver(),resimUri);
                        imageViewResmi.setImageBitmap(secilenResim);


                    }
                    btnKaydet.setEnabled(true);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}