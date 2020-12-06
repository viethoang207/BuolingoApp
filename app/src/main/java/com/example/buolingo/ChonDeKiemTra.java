package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.buolingo.Model.BaiKiemTra;
import com.example.buolingo.Model.TuVung;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChonDeKiemTra extends AppCompatActivity {

    public static String idBaiKiemTra="";
    public static String TenBaiKiemTra="";

    ListView lvSoCap,lvTrungCap,lvCaoCap;
    ArrayList<BaiKiemTra> listBaiKiemTra;
    ArrayList<BaiKiemTra> listSC;
    ArrayList<BaiKiemTra> listTC;
    ArrayList<BaiKiemTra> listCC;
    ArrayAdapter adapterSC,adapterTC,adapterCC;
    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_de_kiem_tra);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();

        readData();

        EventClick();

    }

    private void EventClick() {

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ChonDeKiemTra.this,ManHinhChinh.class);
                startActivity(it);
            }
        });
        lvSoCap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                idBaiKiemTra = listSC.get(position).getIDBaiKiemTra();
                TenBaiKiemTra = listSC.get(position).getTenBaiKiemTra();
                Intent it = new Intent(ChonDeKiemTra.this,KiemTra.class);
                startActivity(it);
            }
        });
    }


    private void readData() {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiKiemTra>> callBack = dataservice.getBaiKiemTra();

        callBack.enqueue(new Callback<List<BaiKiemTra>>() {
            @Override
            public void onResponse(Call<List<BaiKiemTra>> call, Response<List<BaiKiemTra>> response) {
                listBaiKiemTra = (ArrayList<BaiKiemTra>) response.body();
                for(BaiKiemTra b : listBaiKiemTra){
                    if(b.getTrinhDo().equals("socap")){
                        listSC.add(b);
                    }else{
                        if(b.getTrinhDo().equals("trungcap")){
                            listTC.add(b);
                        }
                        if(b.getTrinhDo().equals("caocap")){
                            listCC.add(b);
                        }
                    }
                }
                adapterSC.notifyDataSetChanged();
                adapterTC.notifyDataSetChanged();
                adapterCC.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<BaiKiemTra>> call, Throwable t) {
                Toast.makeText(ChonDeKiemTra.this,"Load data failed",Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void Init() {
        btnHome = (Button) findViewById(R.id.ChonDe_btnHome);
        lvSoCap = (ListView) findViewById(R.id.ChonDe_TASC);
        lvTrungCap = (ListView) findViewById(R.id.ChonDe_TATC);
        lvCaoCap = (ListView) findViewById(R.id.ChonDe_TACC);

        listBaiKiemTra = new ArrayList<>();
        listSC = new ArrayList<>();
        listTC = new ArrayList<>();
        listCC = new ArrayList<>();


        adapterSC = new ArrayAdapter<BaiKiemTra>(ChonDeKiemTra.this, android.R.layout.simple_list_item_1, listSC);
        adapterTC = new ArrayAdapter<BaiKiemTra>(ChonDeKiemTra.this, android.R.layout.simple_list_item_1, listTC);
        adapterCC = new ArrayAdapter<BaiKiemTra>(ChonDeKiemTra.this, android.R.layout.simple_list_item_1, listCC);

        lvSoCap.setAdapter(adapterSC);
        lvTrungCap.setAdapter(adapterTC);
        lvCaoCap.setAdapter(adapterCC);
    }
}