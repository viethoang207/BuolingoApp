package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.buolingo.Model.DongTuBQT;
import com.example.buolingo.Model.TuVung;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XemDTBQT extends AppCompatActivity {
    EditText edtTim;
    ListView lv;
    Adapter_DongTuBQT adapter;
    ArrayList<DongTuBQT> list;
    ArrayList<DongTuBQT> listBackup;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_d_t_b_q_t);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        readData();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogBQT(position);
            }
        });

        textToSpeech = new TextToSpeech(XemDTBQT.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        edtTim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edtTim.getText().toString().length()==0){
                    list.clear();
                    for(DongTuBQT tv : listBackup){
                        list.add(tv);
                    }
                    adapter.notifyDataSetChanged();
                }else{
                    SearchTu(edtTim.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public void SearchTu(String s){
        ArrayList<DongTuBQT> listSearch = new ArrayList<>();
        for(DongTuBQT tv : listBackup){
            if(tv.getNt().toLowerCase().contains(s.toLowerCase()) || tv.getQk().toLowerCase().contains(s.toLowerCase()) || tv.getQkpt().toLowerCase().contains(s.toLowerCase()) || tv.getNghia().toLowerCase().contains(s.toLowerCase())){
                listSearch.add(tv);
            }
        }
        list.clear();
        for(DongTuBQT t : listSearch){
            list.add(t);
        }
        adapter.notifyDataSetChanged();
    }

    //Dialog hiển thị lên khi click vào 1 BQT bất kì
    private void DialogBQT(int pos){

        Dialog dialog = new Dialog(XemDTBQT.this);
        dialog.setContentView(R.layout.chitiet_dongtubqt);
        dialog.create();
        dialog.show();

        final TextView tvNT = dialog.findViewById(R.id.ctietBQT_tvNT);
        final TextView tvQK = dialog.findViewById(R.id.ctietBQT_tvQK);
        final TextView tvQKPT = dialog.findViewById(R.id.ctietBQT_tvQKPT);

        tvNT.setText(listBackup.get(pos).getNt());
        tvQK.setText(listBackup.get(pos).getQk());
        tvQKPT.setText(listBackup.get(pos).getQkpt());

        tvNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak(tvNT.getText().toString());
            }
        });

        tvQK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tvQK.getText().toString();
                if(s.toLowerCase().contains("/")){
                    String cut = s.substring(s.indexOf("/")+1);
                    s = cut;
                }
                speak(s);
            }
        });

        tvQKPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tvQKPT.getText().toString();
                if(s.toLowerCase().contains("/")){
                    String cut = s.substring(s.indexOf("/")+1);
                    s = cut;
                }
                speak(s);
            }
        });
    }

    private void speak(String s){
        int speech = textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);
    }

    private void readData() {
        Dataservice dataservice = APIService.getService();
        Call<List<DongTuBQT>> callBack = dataservice.getDongTuBQT();
        callBack.enqueue(new Callback<List<DongTuBQT>>() {
            @Override
            public void onResponse(Call<List<DongTuBQT>> call, Response<List<DongTuBQT>> response) {
                ArrayList<DongTuBQT> l = new ArrayList<>();
                l = (ArrayList<DongTuBQT>) response.body();
                for(DongTuBQT dt : l){
                    list.add(dt);
                    listBackup.add(dt);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<DongTuBQT>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        edtTim = (EditText) findViewById(R.id.XemBQT_edtTimTu);
        lv = (ListView) findViewById(R.id.XemBQT_lv);

        list = new ArrayList<>();
        listBackup = new ArrayList<>();
        adapter = new Adapter_DongTuBQT(XemDTBQT.this,list);
        lv.setAdapter(adapter);
    }
}