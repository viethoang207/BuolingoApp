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
import com.example.buolingo.Model.TuVungYeuThich;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterTuVungYeuThich extends BaseAdapter {
    Context context;

    ArrayList<TuVungYeuThich> list;

    public AdapterTuVungYeuThich(Context context, ArrayList<TuVungYeuThich> list) {
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
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.dong_yeuthich, parent,false);

        ImageView imgTu = row.findViewById(R.id.dongYeuThich_img);
        TextView tvTu = row.findViewById(R.id.dongYeuThich_tv);


        TuVungYeuThich tv = list.get(position);

        tvTu.setText(tv.getTu());


        if(tv.getAnh().equals("")){
            imgTu.setImageResource(R.drawable.ic_image);
        }else{
            Picasso.get().load(tv.getAnh()).into(imgTu);
        }


        return row;
    }
}
