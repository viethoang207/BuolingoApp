package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.buolingo.Model.TuVung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlashCard extends AppCompatActivity {
    ArrayList<TuVung> listTV;
    AdapterViewPager adapter;
    ViewPager viewPager;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FlashCard.this,ChucNang_TuVung.class);
                startActivity(it);
            }
        });
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TuVung>> callBack = dataservice.getTuVung();
        callBack.enqueue(new Callback<List<TuVung>>() {
            @Override
            public void onResponse(Call<List<TuVung>> call, Response<List<TuVung>> response) {
                ArrayList<TuVung> l = new ArrayList<>();
                l = (ArrayList<TuVung>) response.body();
                Collections.shuffle(l);
                for(TuVung t : l){
                    listTV.add(t);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<TuVung>> call, Throwable t) {
                Toast.makeText(FlashCard.this,"Get data failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Init() {
        listTV = new ArrayList<>();
        btnBack = (Button) findViewById(R.id.FC_btnBack);
        getData();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new AdapterViewPager(FlashCard.this,listTV);
        viewPager.setAdapter(adapter);
    }
}