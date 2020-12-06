package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.buolingo.Model.ChuDeVideo;
import com.example.buolingo.Model.MauCau;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachVideo extends AppCompatActivity {
    ListView lv;
    ArrayList<ChuDeVideo> list;
    Adapter_ChuDeVideo adapter;
    public static ChuDeVideo cd  = new ChuDeVideo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_video);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        readData();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cd = list.get(position);


                Intent it = new Intent(DanhSachVideo.this,XemVideo.class);
                startActivity(it);
            }
        });
    }

    private void readData() {
        Dataservice dataservice = APIService.getService();
        Call<List<ChuDeVideo>> callBack = dataservice.getChuDeVideo();
        callBack.enqueue(new Callback<List<ChuDeVideo>>() {
            @Override
            public void onResponse(Call<List<ChuDeVideo>> call, Response<List<ChuDeVideo>> response) {
                ArrayList<ChuDeVideo> l = new ArrayList<>();
                l = (ArrayList<ChuDeVideo>) response.body();
                for(ChuDeVideo c : l){
                    list.add(c);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ChuDeVideo>> call, Throwable t) {
                Toast.makeText(DanhSachVideo.this,"Lấy dữ liệu thất bại",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Init() {
        lv = (ListView) findViewById(R.id.DSVD_lv);
        list = new ArrayList<>();
        adapter = new Adapter_ChuDeVideo(DanhSachVideo.this,list);
        lv.setAdapter(adapter);
    }
}