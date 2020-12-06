package com.example.buolingo;

import android.app.Activity;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.buolingo.Model.TuVung;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class AdapterViewPager extends PagerAdapter {
    Activity activity;
    ArrayList<TuVung> list;
    LayoutInflater inflater;
    TextToSpeech textToSpeech;
    public AdapterViewPager(Activity activity, ArrayList<TuVung> list) {
        this.activity = activity;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item,container,false);

        textToSpeech = new TextToSpeech(activity.getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        ImageView img = itemView.findViewById(R.id.VPI_img);
        final TextView tvTu = itemView.findViewById(R.id.VPI_tvTu);
        final TextView tvNghia = itemView.findViewById(R.id.VPI_tvNghia);


        TuVung tv = list.get(position);


        if(tv.getAnh().equals("")){
            img.setImageResource(R.drawable.ic_image);
        }else{
            Picasso.get().load(tv.getAnh()).into(img);
        }

        tvTu.setText(tv.getTu());
        tvNghia.setText(tv.getNghia());

        tvTu.setVisibility(View.GONE);
        tvNghia.setVisibility(View.GONE);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTu.setVisibility(View.VISIBLE);
                tvNghia.setVisibility(View.VISIBLE);

                String s = tvTu.getText().toString();

                int speech = textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        tvTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tvTu.getText().toString();

                int speech = textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View)object);
    }
}
