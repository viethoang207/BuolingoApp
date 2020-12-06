package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lyt_DangKy3 extends AppCompatActivity {
    TextView txtTenDN;
    Button btnTiepTuc;
    EditText edtNhapTenDN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky_tendangnhap);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        EventButton();
    }

    private void EventButton() {
        edtNhapTenDN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnTiepTuc.setBackground(getDrawable(R.drawable.botron_tieptuc_after));
                btnTiepTuc.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(edtNhapTenDN.getText().toString().length()<1){
                    btnTiepTuc.setBackground(getDrawable(R.drawable.botron_tieptuc));
                    btnTiepTuc.setEnabled(false);
                }
            }
        });


        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Lyt_DangKy3.this,Lyt_dangkyMK.class);
                startActivity(it);
            }
        });
    }

    private void Init() {
        txtTenDN = (TextView) findViewById(R.id.DangKy3_textDiaChiEmail);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font_Harabara.ttf");
        txtTenDN.setTypeface(typeface);

        edtNhapTenDN = (EditText) findViewById(R.id.DangKy3_edtTenDN);
        btnTiepTuc = (Button) findViewById(R.id.DangKy3_btnTiepTuc);
        btnTiepTuc.setEnabled(false);
    }
}