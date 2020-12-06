package com.example.buolingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buolingo.Model.TinTuc;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_TinTuc extends BaseAdapter {
    Context context;
    ArrayList<TinTuc> list;

    public Adapter_TinTuc(Context context, ArrayList<TinTuc> list) {
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
        View row = inflater.inflate(R.layout.dong_tintuc, parent,false);

        ImageView img = row.findViewById(R.id.dongtintuc_img);
        TextView tv = row.findViewById(R.id.dongtintuc_tvNoiDung);

        TinTuc tt = list.get(position);
        tv.setText(tt.getNDTinTuc());
        if(tt.getAnh().equals("")){
            img.setImageResource(R.drawable.ic_image);
        }else{
            Picasso.get().load(tt.getAnh()).into(img);
        }
        return row;
    }
}
