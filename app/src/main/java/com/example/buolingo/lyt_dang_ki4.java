package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class lyt_dang_ki4 extends AppCompatActivity {
    TextView tvHoanTat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky_matkhau);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
    }

    private void Init() {
        tvHoanTat = (TextView) findViewById(R.id.DangKy4_textHoanTat);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font_Harabara.ttf");
        tvHoanTat.setTypeface(typeface);
    }
}