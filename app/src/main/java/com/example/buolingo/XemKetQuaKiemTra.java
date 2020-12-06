package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class XemKetQuaKiemTra extends AppCompatActivity {
    TextView tvTenDe,tvThoigian,tvSoCauDung,tvDanhGia;
    Button btnTroLai,btnXemDA;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_ket_qua_kiem_tra);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();

        btnXemDA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(XemKetQuaKiemTra.this,XemDapAn.class);
                startActivity(it);
            }
        });

        btnTroLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(XemKetQuaKiemTra.this,ChonDeKiemTra.class);
                startActivity(it);
            }
        });
    }

    private void Init() {
        tvTenDe = (TextView) findViewById(R.id.XemKQ_tvTenDeThi);
        tvThoigian = (TextView) findViewById(R.id.XemKQ_tvThoiGian);
        tvSoCauDung = (TextView) findViewById(R.id.XemKQ_tvSoCauDung);
        tvDanhGia = (TextView) findViewById(R.id.XemKQ_tvDanhGia);

        btnTroLai = (Button) findViewById(R.id.XemKQ_btnTroLai);
        btnXemDA = (Button) findViewById(R.id.XemKQ_btnXemDA);

        tvTenDe.setText(ChonDeKiemTra.TenBaiKiemTra);
        tvSoCauDung.setText(KiemTra.cauDung+"/"+KiemTra.listCH.size());

        float per_true = (KiemTra.cauDung * 100)/KiemTra.listCH.size();
        if(per_true<10){
            tvDanhGia.setText("Yếu");
        }else{
            if(10<=per_true &&per_true<50){
                tvDanhGia.setText("Trung bình");
            }
            if(50<=per_true &&per_true<80){
                tvDanhGia.setText("Khá");
            }
            if(per_true>=80){
                tvDanhGia.setText("Xuất sắc");
            }
        }

        int tg = KiemTra.thoiGian;
        int minute = tg/60;
        int second = tg - (minute*60);
        tvThoigian.setText(minute+" phút "+second+" s");

        mediaPlayer =mediaPlayer.create(XemKetQuaKiemTra.this, R.raw.chucmung);

        mediaPlayer.start();

    }
}