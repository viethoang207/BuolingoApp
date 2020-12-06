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

public class Lyt_DangKi1 extends AppCompatActivity {
    TextView txtBanTenGi;
    Button btnTiepTuc;
    EditText edtNhapTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky_ten);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        EventButton();


    }

    private void EventButton() {
        edtNhapTen.addTextChangedListener(new TextWatcher() {
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
                if(edtNhapTen.getText().toString().length()<1){
                    btnTiepTuc.setBackground(getDrawable(R.drawable.botron_tieptuc));
                    btnTiepTuc.setEnabled(false);
                }
            }
        });


        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Lyt_DangKi1.this,Lyt_DangKy2.class);
                startActivity(it);
            }
        });
    }

    private void Init() {
        txtBanTenGi = (TextView) findViewById(R.id.DangKy1_textBanTenGi);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font_Harabara.ttf");
        txtBanTenGi.setTypeface(typeface);

        edtNhapTen = (EditText) findViewById(R.id.DangKy1_edtTen);
        btnTiepTuc = (Button) findViewById(R.id.DangKy1_btnTiepTuc);
        btnTiepTuc.setEnabled(false);
    }
}