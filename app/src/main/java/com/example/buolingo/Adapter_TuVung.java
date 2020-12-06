package com.example.buolingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buolingo.Model.TuVung;
import com.example.buolingo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_TuVung extends BaseAdapter {
    Context context;
    ArrayList<TuVung> list;

    public Adapter_TuVung(Context context, ArrayList<TuVung> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.dong_tu_vung, parent,false);

        ImageView imgTu = row.findViewById(R.id.dongTV_imgTu);
        TextView tvTu = row.findViewById(R.id.dongTV_tvTu);
        TextView tvNghia = row.findViewById(R.id.dongTV_tvNghia);

        TuVung tv = list.get(position);

        tvTu.setText(tv.getTu());
        tvNghia.setText(tv.getNghia());

        if(tv.getAnh().equals("")){
            imgTu.setImageResource(R.drawable.ic_image);
        }else{
            Picasso.get().load(tv.getAnh()).into(imgTu);
        }

        Animation anim_lv = AnimationUtils.loadAnimation(context, R.anim.anim_listview);
        row.startAnimation(anim_lv);
        return row;
    }
}
