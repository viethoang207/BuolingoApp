package com.example.buolingo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buolingo.Model.KetQua;

import java.util.ArrayList;

public class AdapterXemDapAn  extends BaseAdapter {
    Context context;
    ArrayList<KetQua> list;

    public AdapterXemDapAn(Context context, ArrayList<KetQua> list) {
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
        View row = inflater.inflate(R.layout.dong_dapan, parent,false);

        ImageView img = row.findViewById(R.id.dongDA_img);

        TextView tvCH = row.findViewById(R.id.dongDA_tvCH);
        TextView tvChon = row.findViewById(R.id.dongDA_tvDAChon);
        TextView tvDA = row.findViewById(R.id.dongDA_tvDADung);

        if(list.get(position).DA_chon.equals(list.get(position).DA_dung)){
            tvChon.setText(list.get(position).DA_dung);
            tvChon.setTextColor(Color.parseColor("#673AB7"));
            tvDA.setText("");
        }else{
            tvChon.setText("Chọn : "+list.get(position).DA_chon);
            tvDA.setText("Đáp án đúng : "+list.get(position).DA_dung);
            img.setImageResource(R.drawable.icon_false);
        }

        tvCH.setText(list.get(position).CauHoi);


        return row;
    }
}
