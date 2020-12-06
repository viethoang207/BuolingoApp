package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buolingo.Model.TuVung;
import com.example.buolingo.Model.TuVungYeuThich;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class ChiTiet_TuVung extends AppCompatActivity {
    TextView tvTu,tvNghia;
    ImageButton btnNghe,btnBack,btnYT;
    ImageView img;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet__tu_vung);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        Toast.makeText(ChiTiet_TuVung.this,""+ChucNang_TuVung.listYT.size(),Toast.LENGTH_SHORT).show();
        tvTu = (TextView) findViewById(R.id.ChiTietTu_tvTu);
        tvNghia = (TextView) findViewById(R.id.ChiTietTu_tvNghia);
        btnNghe = (ImageButton) findViewById(R.id.ChiTietTu_imbSpeak);
        btnBack = (ImageButton) findViewById(R.id.ChiTietTu_imb_back);

        img = (ImageView) findViewById(R.id.ChiTietTu_imgTu);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ChiTiet_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        textToSpeech = new TextToSpeech(ChiTiet_TuVung.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        TuVung tv = new TuVung();
        tv.setIdTL(XemTuVungTheoTheLoai.chose.getIdTL());
        tv.setTu(XemTuVungTheoTheLoai.chose.getTu());
        tv.setNghia(XemTuVungTheoTheLoai.chose.getNghia());
        tv.setAnh(XemTuVungTheoTheLoai.chose.getAnh());

        String ck = XemTuVungTheoTheLoai.chose.getTu();

        tvTu.setText(tv.getTu());
        tvNghia.setText(tv.getNghia());
        String t = tvTu.getText().toString();






        if(tv.getAnh().equals("")){
            img.setImageResource(R.drawable.ic_image);
        }else{
            Picasso.get().load(tv.getAnh()).into(img);
        }



        btnNghe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tvTu.getText().toString();

                int speech = textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }


}