package com.example.kelimedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MenuAdapter extends ArrayAdapter<String> {
    private String[] konular;
    private String[] fransizcaKonular;
    private int[] resimler;
    private Context context;

    private TextView konuIsmi,konuIsmiF;
    private ImageView menuResmi;

    public MenuAdapter(String[] konular,String[] fransizcaKonular, int[] resimler,Context context){
        super(context, R.layout.menulist_item,konular);
        this.konular=konular;
        this.fransizcaKonular=fransizcaKonular;
        this.resimler=resimler;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.menulist_item,null);
        if(view !=null){
            konuIsmi=(TextView) view.findViewById(R.id.menulist_item_Menu_Turkce);
            konuIsmiF=(TextView) view.findViewById(R.id.menulist_item_Menu_Fransizca);
            menuResmi=(ImageView)view.findViewById(R.id.menulist_item_imageViewResim);

            konuIsmi.setText(konular[position]);
            konuIsmiF.setText(fransizcaKonular[position]);
            menuResmi.setBackgroundResource(resimler[position]);
        }
        return view;
    }
}
