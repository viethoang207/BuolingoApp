package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buolingo.Model.MauCau;
import com.example.buolingo.Model.TinTuc;
import com.example.buolingo.Model.TuVung;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Layout_TinTuc extends AppCompatActivity {
    TextView tvHoTen,tvStudy;
    LinearLayout ly_nghe1,ly_nghe2,ly_noi1,ly_noi2,ly_tv1,ly_tv2;

    public static String url ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout__tin_tuc);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        tvHoTen.setText(Lyt_DangNhap.hoTenTK);
        ly_nghe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Layout_TinTuc.this,XemTinTuc.class);
                startActivity(it);
                url ="https://nghetienganhpro.com/5-bi-quyet-khong-the-tin-duoc-de-nghe-tieng-anh-tot/";
            }
        });

        ly_nghe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Layout_TinTuc.this,XemTinTuc.class);
                startActivity(it);
                url ="https://tienganhmoingay.com/luyen-nghe-tieng-anh/luyen-nghe-tieng-anh-xem-phu-de/";
            }
        });

        ly_noi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Layout_TinTuc.this,XemTinTuc.class);
                startActivity(it);
                url ="https://langmaster.edu.vn/10-meo-de-tang-cuong-ky-nang-noi-tieng-anh-a15i135.html";
            }
        });

        ly_noi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Layout_TinTuc.this,XemTinTuc.class);
                startActivity(it);
                url ="https://tienganhfree.com/luyen-noi-tieng-anh/ky-nang-noi-tieng-anh";
            }
        });

        ly_tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Layout_TinTuc.this,XemTinTuc.class);
                startActivity(it);
                url ="https://stepup.edu.vn/blog/cach-hoc-tu-vung-tieng-anh-hieu-qua-khong-bao-gio-quen/";
            }
        });

        ly_tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Layout_TinTuc.this,XemTinTuc.class);
                startActivity(it);
                url ="https://leerit.com/cach-hoc-tu-vung-tieng-anh/";
            }
        });


        tvStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Layout_TinTuc.this,ManHinhChinh.class);
                startActivity(it);
            }
        });



    }



    private void Init() {
        tvHoTen = (TextView) findViewById(R.id.TinTuc_tvTenTK);
        tvStudy = (TextView) findViewById(R.id.TinTuc_tvStudy);

        ly_nghe1 = (LinearLayout) findViewById(R.id.lytNghe1);
        ly_nghe2 = (LinearLayout) findViewById(R.id.lytNghe2);
        ly_noi1 = (LinearLayout) findViewById(R.id.lytNoi1);
        ly_noi2 = (LinearLayout) findViewById(R.id.lytNoi2);
        ly_tv1 = (LinearLayout) findViewById(R.id.lytTV1);
        ly_tv2 = (LinearLayout) findViewById(R.id.lytTV2);

    }
}