package com.example.kelimedata;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KelimelerAdapter extends RecyclerView.Adapter<KelimelerAdapter.CardTasarim> {
    private Context mContext;
    private List<Kelimeler> kelimelerList;

    public KelimelerAdapter(Context mContext, List<Kelimeler> kelimelerList) {
        this.mContext = mContext;
        this.kelimelerList = kelimelerList;
    }


    @NonNull
    @Override
    public CardTasarim onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_kelime_tasarim,parent,false);
        return new CardTasarim(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarim holder, int position) {
        final Kelimeler kelimeler=kelimelerList.get(position);
        holder.textViewTurkce1.setText(kelimeler.getKelime_turkce());
        holder.textViewFransizca1.setText(kelimeler.getKelime_fransizca());
        holder.textViewTuru1.setText(kelimeler.getKelime_turu());
        holder.textViewCinsiyeti1.setText(kelimeler.getKelime_cinsiyeti());
        holder.imageViewKelimeResmi1.setImageResource(mContext.getResources().getIdentifier(kelimeler.getKelime_resmi(),"drawable",mContext.getPackageName()));

        holder.card_kelimeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,SozlukActivity2.class);

                intent.putExtra("kelime_nesne",kelimeler);
                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return kelimelerList.size();
    }

    public class CardTasarim extends RecyclerView.ViewHolder{
        private CardView card_kelimeler;
        private TextView textViewFransizca1,textViewTurkce1,textViewTuru1,textViewCinsiyeti1;
        ImageView imageViewKelimeResmi1;

        public CardTasarim(@NonNull View itemView) {
            super(itemView);
            card_kelimeler=itemView.findViewById(R.id.card_kelimeler);
            textViewTurkce1=itemView.findViewById(R.id.textViewTurkce1);
            textViewFransizca1=itemView.findViewById(R.id.textViewFransizca1);
            textViewTuru1=itemView.findViewById(R.id.textViewTuru1);
            textViewCinsiyeti1=itemView.findViewById(R.id.textViewCinsiyeti1);
            imageViewKelimeResmi1=itemView.findViewById(R.id.imageViewKelimeResmi1);
        }
    }
}
