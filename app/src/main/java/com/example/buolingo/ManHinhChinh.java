package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.buolingo.Model.TinTuc;

public class ManHinhChinh extends AppCompatActivity {

    Button btnTuVung,btnMauCau,btnDongTuBQT,btnVideo,btnBKT,btnTrangChu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Init();
        EventClick();
    }



    private void Init() {
        btnTuVung = (Button) findViewById(R.id.MHC_btnTuVung);
        btnMauCau = (Button) findViewById(R.id.MHC_btnTraCau);
        btnDongTuBQT = (Button) findViewById(R.id.MHC_btnBangDongTu);
        btnVideo = (Button) findViewById(R.id.MHC_btnVideo);
        btnBKT = (Button) findViewById(R.id.MHC_btnKiemTra);
        btnTrangChu = (Button) findViewById(R.id.MHC_btnTrangChu);
    }

    private void EventClick() {

        btnTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ManHinhChinh.this, Layout_TinTuc.class);
                startActivity(it);
            }
        });

        btnBKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ManHinhChinh.this,ChonDeKiemTra.class);
                startActivity(it);
            }
        });
        btnTuVung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ManHinhChinh.this,ChucNang_TuVung.class);
                startActivity(it);
            }
        });

        btnMauCau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ManHinhChinh.this,XemMauCau.class);
                startActivity(it);
            }
        });

        btnDongTuBQT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ManHinhChinh.this,XemDTBQT.class);
                startActivity(it);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ManHinhChinh.this,DanhSachVideo.class);
                startActivity(it);
            }
        });
    }
}