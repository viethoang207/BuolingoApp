package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buolingo.Model.TuVung;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XemTuVungTheoTheLoai extends AppCompatActivity {
    ListView lv;
    Adapter_TuVung adapter;
    EditText edtTimTuVung;

    TextView tvTenTheLoai;
    ArrayList<TuVung> listTuVungTheoTL = new ArrayList<>();
    ArrayList<TuVung> listAllTuVung = new ArrayList<>();
    ArrayList<TuVung> listBackup = new ArrayList<>();
    String theloaitu = ChucNang_TuVung.theloai;

    //Từ được chọn
    public static TuVung chose = new TuVung();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xem_tu_vung_theo_the_loai);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();


        tvTenTheLoai.setText("CHỦ ĐỀ : "+theloaitu.toUpperCase());
        getData();

        EventClick();

    }

    private void EventClick() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chose.setAnh(listTuVungTheoTL.get(position).getAnh());
                chose.setIdTL(listTuVungTheoTL.get(position).getIdTL());
                chose.setNghia(listTuVungTheoTL.get(position).getNghia());
                chose.setTu(listTuVungTheoTL.get(position).getTu());

                Intent it = new Intent(XemTuVungTheoTheLoai.this,ChiTiet_TuVung.class);
                startActivity(it);
            }
        });

        edtTimTuVung.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(edtTimTuVung.getText().toString().length()==0){
                        listTuVungTheoTL.clear();
                        for(TuVung tv : listBackup){
                            listTuVungTheoTL.add(tv);
                        }
                        adapter.notifyDataSetChanged();
                    }else{
                        SearchTu(edtTimTuVung.getText().toString());
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void SearchTu(String s){
        ArrayList<TuVung> listSearch = new ArrayList<>();
        for(TuVung tv : listBackup){
            if(tv.getTu().toLowerCase().contains(s.toLowerCase()) || tv.getNghia().toLowerCase().contains(s.toLowerCase())){
                listSearch.add(tv);
            }
        }
        listTuVungTheoTL.clear();
        for(TuVung t : listSearch){
            listTuVungTheoTL.add(t);
        }
        adapter.notifyDataSetChanged();
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TuVung>> callBack = dataservice.getTuVung();
        callBack.enqueue(new Callback<List<TuVung>>() {
            @Override
            public void onResponse(Call<List<TuVung>> call, Response<List<TuVung>> response) {
                listAllTuVung = (ArrayList<TuVung>) response.body();
                for(TuVung tv : listAllTuVung){
                    if(tv.getIdTL().equals(theloaitu)){
                        listTuVungTheoTL.add(tv);
                        listBackup.add(tv);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<TuVung>> call, Throwable t) {
                Toast.makeText(XemTuVungTheoTheLoai.this,"Lấy dữ liệu thất bại",Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void Init() {
        lv = (ListView) findViewById(R.id.XemTuVung_lv);

        edtTimTuVung = (EditText) findViewById(R.id.XemTuVung_edtTimTu);

        tvTenTheLoai = (TextView) findViewById(R.id.XemTuVung_tvChuDe);

        adapter = new Adapter_TuVung(XemTuVungTheoTheLoai.this,listTuVungTheoTL);
        lv.setAdapter(adapter);
    }
}