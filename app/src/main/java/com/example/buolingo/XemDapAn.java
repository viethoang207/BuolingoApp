package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.example.buolingo.Model.CauHoi;
import com.example.buolingo.Model.CauTraLoi;
import com.example.buolingo.Model.KetQua;

import java.util.ArrayList;

public class XemDapAn extends AppCompatActivity {
    Button btnBack;
    ListView lv;
    ArrayList<CauHoi> listCH;
    ArrayList<CauTraLoi> listCTL;
    ArrayList<KetQua> listKQ;
    AdapterXemDapAn adapterXemDapAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_dap_an);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();
        getData();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(XemDapAn.this,ChonDeKiemTra.class);
                startActivity(it);
            }
        });
    }

    private void getData() {

        //get data cau hoi
        for(CauHoi ch : KiemTra.listCH){
            listCH.add(ch);
        }

        //get data CTL
        for (CauTraLoi ctl : KiemTra.listCTL){
            listCTL.add(ctl);
        }

        for(int i=0;i<listCH.size();++i){
            KetQua kq = new KetQua();
            kq.CauHoi = listCH.get(i).getNDCauHoi();

            String chon = listCTL.get(i).getDA_chon();
            String da = listCH.get(i).getDADung();
            switch (chon){
                case "A":
                    chon = "A."+listCH.get(i).getDA1();
                    break;
                case "B":
                    chon = "B."+listCH.get(i).getDA2();
                    break;
                case "C":
                    chon = "C."+listCH.get(i).getDA3();
                    break;
                case "D":
                    chon = "D."+listCH.get(i).getDA4();
                    break;
                case "E":
                    chon = "Chưa chọn đáp án";
                    break;
            }

            switch (da){
                case "A":
                    da = "A."+listCH.get(i).getDA1();
                    break;
                case "B":
                    da = "B."+listCH.get(i).getDA2();
                    break;
                case "C":
                    da = "C."+listCH.get(i).getDA3();
                    break;
                case "D":
                    da = "D."+listCH.get(i).getDA4();
                    break;

            }

            kq.DA_chon =chon;
            kq.DA_dung=da;

            listKQ.add(kq);
        }
        adapterXemDapAn.notifyDataSetChanged();
    }

    private void Init() {
        btnBack = (Button) findViewById(R.id.XemDA_btnBack);

        lv = (ListView) findViewById(R.id.XemDA_lv);

        listCH = new ArrayList<>();
        listCTL = new ArrayList<>();
        listKQ= new ArrayList<>();
        adapterXemDapAn = new AdapterXemDapAn(XemDapAn.this,listKQ);
        lv.setAdapter(adapterXemDapAn);
    }
}