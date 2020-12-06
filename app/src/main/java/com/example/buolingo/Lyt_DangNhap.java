package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buolingo.Model.TaiKhoan;
import com.example.buolingo.Model.TinTuc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lyt_DangNhap extends AppCompatActivity {
    TextView txtDangNhap;
    EditText edtID,edtPW;
    Button btnDN;
    ArrayList<TaiKhoan> listTK;
    public static String hoTenTK ="";
    public static String idnd ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyt__dang_nhap);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        getTaiKhoan();
        EventClick();
        btnDN.setClickable(false);
    }

    private void EventClick() {
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                String pw = edtPW.getText().toString();

                if(id.length()>0 && pw.length()>0){
                    if(CheckDN(id,pw)==true){
                        idnd = id;
                        Intent it = new Intent(Lyt_DangNhap.this,Layout_TinTuc.class);
                        startActivity(it);
                    }else{
                        edtPW.setText("");
                        Toast.makeText(Lyt_DangNhap.this,"Tên tài khoản hoặc mật khẩu không đúng.",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Lyt_DangNhap.this,"Tên tài khoản hoặc mật khẩu không được trống",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public boolean CheckDN(String id, String pw){
        for(TaiKhoan tk : listTK){
            if(tk.getID().toLowerCase().equals(id.toLowerCase())){
                if(tk.getPW().equals(pw)){
                    hoTenTK = tk.getHoTen();
                    return  true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    private void getTaiKhoan() {
        Dataservice dataservice = APIService.getService();
        Call<List<TaiKhoan>> callBack = dataservice.getTaiKhoan();
        callBack.enqueue(new Callback<List<TaiKhoan>>() {
            @Override
            public void onResponse(Call<List<TaiKhoan>> call, Response<List<TaiKhoan>> response) {
                ArrayList<TaiKhoan> l = new ArrayList<>();
                l = (ArrayList<TaiKhoan>) response.body();
                for(TaiKhoan tk : l){
                    listTK.add(tk);
                }

                btnDN.setClickable(true);



            }

            @Override
            public void onFailure(Call<List<TaiKhoan>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        txtDangNhap = (TextView) findViewById(R.id.DangNhap_txtDangNhap);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fontBanda.otf");
        txtDangNhap.setTypeface(typeface);

        edtID = (EditText) findViewById(R.id.DangNhap_edtTK);
        edtPW = (EditText) findViewById(R.id.DangNhap_edtMK);

        listTK = new ArrayList<>();

        btnDN = (Button) findViewById(R.id.DangNhap_btnDangNhap);
    }
}