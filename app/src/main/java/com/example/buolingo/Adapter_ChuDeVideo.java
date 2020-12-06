package com.example.buolingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.buolingo.Model.ChuDeVideo;

import java.util.ArrayList;

public class Adapter_ChuDeVideo extends BaseAdapter {
    Context context;
    ArrayList<ChuDeVideo> list;

    public Adapter_ChuDeVideo(Context context, ArrayList<ChuDeVideo> list) {
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
        View row = inflater.inflate(R.layout.dong_chudevideo, parent,false);

        TextView tvTenCD = row.findViewById(R.id.dongCDVD_TenChuDeVD);
        TextView tvND = row.findViewById(R.id.dongCDVD_NoiDungChuDeVD);

        tvTenCD.setText(list.get(position).getTenChuDeVideo());
        tvND.setText(list.get(position).getNoiDungChuDe());
        return row;
    }
}
