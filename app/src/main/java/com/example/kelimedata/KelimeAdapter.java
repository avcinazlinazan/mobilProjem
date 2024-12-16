package com.example.kelimedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KelimeAdapter extends RecyclerView.Adapter<KelimeAdapter.KeliemeHolder>{
    private ArrayList<Kelime> kelimeList;
    Context context;

    public KelimeAdapter(ArrayList<Kelime> kelimeList, Context context) {
        this.kelimeList = kelimeList;
        this.context = context;
    }

    @NonNull
    @Override
    public KeliemeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.my_row,parent,false);
        return new KeliemeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KeliemeHolder holder, int position) {
        Kelime kelime=kelimeList.get(position);
        holder.setData(kelime);

    }

    @Override
    public int getItemCount() {
        return kelimeList.size();
    }

    class KeliemeHolder extends RecyclerView.ViewHolder{
        TextView textTurkce,textFransizca,textTuru,textCinsiyeti;
        ImageView imageViewResmi;
        public KeliemeHolder(@NonNull View itemView) {
            super(itemView);
            textTurkce=(TextView)itemView.findViewById(R.id.text_item_Turkce);
            textFransizca=(TextView)itemView.findViewById(R.id.text_item_Fransizca);
            textTuru=(TextView)itemView.findViewById(R.id.text_item_Turu);
            textCinsiyeti=(TextView)itemView.findViewById(R.id.text_item_Cinsiyeti);
            imageViewResmi=(ImageView)itemView.findViewById(R.id.imageViewKonuResmi);

        }

        public void setData(Kelime kelime){
            this.textTurkce.setText(kelime.getTurkce());
            this.textFransizca.setText(kelime.getFransizca());
            this.textTuru.setText(kelime.getTuru());
            this.textCinsiyeti.setText(kelime.getCinsiyeti());
            this.imageViewResmi.setImageBitmap(kelime.getResmi());
        }
    }
}
