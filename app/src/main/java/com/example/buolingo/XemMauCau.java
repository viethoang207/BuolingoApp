package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.buolingo.Model.MauCau;
import com.example.buolingo.Model.TuVung;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XemMauCau extends AppCompatActivity {
    EditText edtTimMauCau;
    ListView lvMauCau;
    ArrayList<MauCau> listMauCau;
    ArrayList<MauCau> listBackup;
    Adapter_MauCau adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mau_cau);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        readData();

        edtTimMauCau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edtTimMauCau.getText().toString().length()==0){
                    listMauCau.clear();
                    for(MauCau mc : listBackup){
                        listMauCau.add(mc);
                    }
                    adapter.notifyDataSetChanged();
                }else{
                    SearchMC(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void SearchMC(String s){
        ArrayList<MauCau> listSearch = new ArrayList<>();
        for(MauCau mc : listBackup){
            if(mc.getMaucau().toLowerCase().contains(s.toLowerCase()) || mc.getNghia().toLowerCase().contains(s.toLowerCase())){
                listSearch.add(mc);
            }
        }
        listMauCau.clear();
        for(MauCau t : listSearch){
            listMauCau.add(t);
        }
        adapter.notifyDataSetChanged();
    }

    private void readData() {
        Dataservice dataservice = APIService.getService();
        Call<List<MauCau>> callBack = dataservice.getMauCau();
        callBack.enqueue(new Callback<List<MauCau>>() {
            @Override
            public void onResponse(Call<List<MauCau>> call, Response<List<MauCau>> response) {
                ArrayList<MauCau> l = new ArrayList<>();
                l = (ArrayList<MauCau>) response.body();
                for(MauCau mc : l){
                    listMauCau.add(mc);
                    listBackup.add(mc);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<MauCau>> call, Throwable t) {
                Toast.makeText(XemMauCau.this,"Lấy dữ liệu thất bại",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Init() {
        edtTimMauCau = (EditText) findViewById(R.id.XemMauCau_edtTimMC);
        lvMauCau = (ListView) findViewById(R.id.XemMauCau_lvMauCau);
        listBackup = new ArrayList<>();
        listMauCau = new ArrayList<>();
        adapter = new Adapter_MauCau(XemMauCau.this,listMauCau);
        lvMauCau.setAdapter(adapter);
    }
}