package com.example.kelimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private Button btnGirisYap;
    private EditText editEmail,editSifre;
    private TextView txtSonuc;
    private String kAdi,kSifre,dogruKAdi="naz",dogruKSifre="123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnGirisYap =findViewById(R.id.btnGiris);
        editEmail=findViewById(R.id.editEmail);
        editSifre=findViewById(R.id.editSifre);
        txtSonuc=(TextView)findViewById(R.id.txtSonuc);
    }
    public void btnGirisYap(View v){
        kAdi=editEmail.getText().toString();
        kSifre=editSifre.getText().toString();

        if(!TextUtils.isEmpty(kAdi)){
            if(kAdi.equals(dogruKAdi)){
                if(!TextUtils.isEmpty((kSifre))){
                    if(kSifre.equals((dogruKSifre))){
                        Intent intent = new Intent(LoginActivity.this,ContentActivity.class);
                        intent.putExtra("kullaniciAdi",kAdi);
                        startActivity(intent);
                    }else
                        txtSonuc.setText("Şifrenizi yanlış girdiniz");
                }else
                    txtSonuc.setText("Kullanıcı adınızı yanlış girdiniz");
            }else
                txtSonuc.setText("Şifrenizi boş bırakamazsınız");
        }else
            txtSonuc.setText("Kullanıcı adınızı boş bırakamazsınız");


    }
}