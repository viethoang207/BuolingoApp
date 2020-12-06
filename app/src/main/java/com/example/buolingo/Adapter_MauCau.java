package com.example.buolingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.buolingo.Model.MauCau;

import java.util.ArrayList;

public class Adapter_MauCau extends BaseAdapter {
    Context context;
    ArrayList<MauCau> list;

    public Adapter_MauCau(Context context, ArrayList<MauCau> list) {
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
        View row = inflater.inflate(R.layout.dong_maucau, parent,false);

        TextView tvMC = row.findViewById(R.id.dongMC_tvMauCau);
        TextView tvNghia = row.findViewById(R.id.dongMC_tvNghia);
        TextView tvViDu = row.findViewById(R.id.dongMC_tvViDu);


        MauCau mc = list.get(position);
        tvMC.setText(mc.getMaucau());
        tvNghia.setText(mc.getNghia());
        tvViDu.setText(mc.getVidu());



        Animation anim_lv = AnimationUtils.loadAnimation(context, R.anim.anim_listview);
        row.startAnimation(anim_lv);


        return row;
    }
}
