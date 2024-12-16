package com.example.kelimedata;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SozlukAdapter  extends RecyclerView.Adapter<SozlukAdapter.CardTasarim> {
    private Context mContext;
    private List<Kelimeler> sozlukList;

    public SozlukAdapter(Context mContext, List<Kelimeler> sozlukList) {
        this.mContext = mContext;
        this.sozlukList = sozlukList;
    }

    @NonNull
    @Override
    public CardTasarim onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sozluk_tasarim,parent,false);
        return new CardTasarim(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarim holder, int position) {
        Kelimeler kelimeler=sozlukList.get(position);
        holder.textViewTurkce.setText(kelimeler.getKelime_turkce());
        holder.textViewFransizca.setText(kelimeler.getKelime_fransizca());
        holder.kelime_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,SozlukActivity.class);
                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return sozlukList.size();
    }

    public class CardTasarim extends RecyclerView.ViewHolder{
        private CardView kelime_card;
        private TextView textViewTurkce,textViewFransizca;

        public CardTasarim(@NonNull View itemView) {
            super(itemView);
            kelime_card=itemView.findViewById(R.id.Cumle_card);
            textViewTurkce=itemView.findViewById(R.id.textViewTurkcem);
            textViewFransizca=itemView.findViewById(R.id.textViewFransizcam);
        }
    }



}
