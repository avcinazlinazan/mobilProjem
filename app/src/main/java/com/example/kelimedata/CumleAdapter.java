package com.example.kelimedata;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CumleAdapter extends RecyclerView.Adapter<CumleAdapter.CardTasarim> {
    private Context mContext;
    private List<Cumleler> cumlelerList;

    public CumleAdapter(Context mContext, List<Cumleler> cumlelerList) {
        this.mContext = mContext;
        this.cumlelerList = cumlelerList;
    }

    @NonNull
    @Override
    public CardTasarim onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cumle_tasarim,parent,false);
        return new CardTasarim(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarim holder, int position) {
        final Cumleler cumleler=cumlelerList.get(position);
        holder.textViewTurkceCumlem.setText(cumleler.getCumle_turkce());
        holder.textViewFransizcaCumlem.setText(cumleler.getCumle_fransizca());
        holder.imageViewCumleResmim.setImageResource(mContext.getResources().getIdentifier(cumleler.getCumle_resmi(),"drawable",mContext.getPackageName()));
        holder.cumle_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,AyrintiActivity.class);

                intent.putExtra("nesne",cumleler);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return cumlelerList.size();
    }

    public class CardTasarim extends RecyclerView.ViewHolder{
        private CardView cumle_card;
        private TextView textViewTurkceCumlem,textViewFransizcaCumlem;
        private ImageView imageViewCumleResmim;

        public CardTasarim(@NonNull View itemView) {
            super(itemView);
            cumle_card=itemView.findViewById(R.id.Cumle_card);
            textViewTurkceCumlem=itemView.findViewById(R.id.textViewTurkcem);
            textViewFransizcaCumlem=itemView.findViewById(R.id.textViewFransizcam);
            imageViewCumleResmim=itemView.findViewById(R.id.imageViewCumleResmim);
        }
    }
}

