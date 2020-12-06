package com.example.buolingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.buolingo.Model.TuVungYeuThich;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChucNang_TuVung extends AppCompatActivity {
    public static String theloai = "";
    Button btnDongVat,btnMauSac,btnQuanAo,btnThucVat,btnGiaDinh,btnNgheNghiep,btnNoiChon,btnDuLich,btnToanHoc,btnGiaoDuc,btnYTe,btnKhoaHoc,btnGG;
    Button btnFC;

    public static ArrayList<TuVungYeuThich> listYT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_tuvung);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();

        EventClick();
    }



    private void Init() {
        btnDongVat = (Button) findViewById(R.id.TuVung_btnDongVat);
        btnMauSac = (Button) findViewById(R.id.TuVung_btnMauSac);


        btnQuanAo = (Button) findViewById(R.id.TuVung_btnQuanAo);
        btnThucVat = (Button) findViewById(R.id.TuVung_btnThucVat);
        btnGiaDinh = (Button) findViewById(R.id.TuVung_btnGiaDinh);
        btnNgheNghiep = (Button) findViewById(R.id.TuVung_btnNgheNghiep);
        btnNoiChon = (Button) findViewById(R.id.TuVung_btnNoiChon);
        btnDuLich = (Button) findViewById(R.id.TuVung_btnDuLich);
        btnToanHoc = (Button) findViewById(R.id.TuVung_btnToanHoc);
        btnGiaoDuc = (Button) findViewById(R.id.TuVung_btnGiaoDuc);
        btnYTe = (Button) findViewById(R.id.TuVung_btnYTe);
        btnKhoaHoc = (Button) findViewById(R.id.TuVung_btnKhoaHoc);
        btnGG = (Button) findViewById(R.id.TuVung_btnGGTrans);
        btnFC = (Button) findViewById(R.id.TuVung_FlashCard);
        listYT = new ArrayList<>();

    }



    private void EventClick() {



        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ChucNang_TuVung.this,FlashCard.class);
                startActivity(it);
            }
        });

        btnGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ChucNang_TuVung.this,ggtrans.class);
                startActivity(it);
            }
        });
        btnDongVat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="dongvat";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnMauSac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="mausac";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnQuanAo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="quanao";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnThucVat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="thucvat";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnGiaDinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="giadinh";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnNgheNghiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="nghenghiep";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnNoiChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="noichon";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnDuLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="dulich";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnToanHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="toanhoc";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnGiaoDuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="giaoduc";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnYTe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="yte";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

        btnKhoaHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theloai ="khoahoc";
                Intent it = new Intent(ChucNang_TuVung.this,XemTuVungTheoTheLoai.class);
                startActivity(it);
            }
        });

    }
}
