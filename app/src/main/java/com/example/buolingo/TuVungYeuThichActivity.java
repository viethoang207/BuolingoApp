package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.buolingo.Model.CauHoi;
import com.example.buolingo.Model.CauTraLoi;
import com.example.buolingo.Model.TuVungYeuThich;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TuVungYeuThichActivity extends AppCompatActivity {
    GridView grv;
    ArrayList<TuVungYeuThich> list;
    AdapterTuVungYeuThich adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_vu_yeu_thich);


        Init();
        getData(Lyt_DangNhap.idnd);



    }

    private void Init() {
        grv = (GridView) findViewById(R.id.YeuThich_GridView);
        list = new ArrayList<>();

        adapter = new AdapterTuVungYeuThich(TuVungYeuThichActivity.this,list);
        grv.setAdapter(adapter);
    }

    private void getData(String idNguoiDung) {
        Dataservice dataservice = APIService.getService();
        Call<List<TuVungYeuThich>> callback = dataservice.getTuVungYeuThich(idNguoiDung);
        callback.enqueue(new Callback<List<TuVungYeuThich>>() {
            @Override
            public void onResponse(Call<List<TuVungYeuThich>> call, Response<List<TuVungYeuThich>> response) {
                ArrayList<TuVungYeuThich> l = (ArrayList<TuVungYeuThich>) response.body();
                for(TuVungYeuThich tvyt : l){
                    list.add(tvyt);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<TuVungYeuThich>> call, Throwable t) {
                Toast.makeText(TuVungYeuThichActivity.this,"Get data failed",Toast.LENGTH_SHORT).show();
            }


        });
    }
}