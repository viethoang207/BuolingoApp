package com.example.buolingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.buolingo.Model.DongTuBQT;

import java.util.ArrayList;

public class Adapter_DongTuBQT extends BaseAdapter {
    Context context;
    ArrayList<DongTuBQT> list;

    public Adapter_DongTuBQT(Context context, ArrayList<DongTuBQT> list) {
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
        View row = inflater.inflate(R.layout.dong_dongtubqt, parent,false);

        TextView tvNguyenThe = row.findViewById(R.id.dongBQT_nguyenthe);
        TextView tvQK = row.findViewById(R.id.dongBQT_quakhu);
        TextView tvQKPT = row.findViewById(R.id.dongBQT_qkpt);
        TextView tvNghia = row.findViewById(R.id.dongBQT_nghia);

        DongTuBQT dt = list.get(position);

        tvNguyenThe.setText(dt.getNt());
        tvQK.setText(dt.getQk());
        tvQKPT.setText(dt.getQkpt());
        tvNghia.setText(dt.getNghia());



        return row;
    }
}
