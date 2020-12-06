package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textBuolingo;
    Button btnDangKy,btnDangNhap;
    MediaPlayer song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Chạy nhạc nền
        //Giai điệu vui tươi phấn khởi =)))
        song = MediaPlayer.create(MainActivity.this,R.raw.background_music);
        song.start();


        Init();

        EventButton();
    }



    private void EventButton() {
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
//                Intent it = new Intent(MainActivity.this,Lyt_DangKi1.class);
//                startActivity(it);
                Intent it = new Intent(MainActivity.this,Lyt_DangKi1.class);
                startActivity(it);
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent it = new Intent(MainActivity.this,Lyt_DangNhap.class);
                startActivity(it);
            }
        });
    }

    private void Init() {
        textBuolingo = (TextView) findViewById(R.id.textBuolingo);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fontBanda.otf");
        textBuolingo.setTypeface(typeface);

        btnDangKy = (Button) findViewById(R.id.LayoutMain_btnBatDauNgay);
        btnDangNhap = (Button) findViewById(R.id.LayoutMain_btnDaCoTaiKhoan);

    }

}