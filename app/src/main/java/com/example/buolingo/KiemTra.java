package com.example.buolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buolingo.Model.CauHoi;
import com.example.buolingo.Model.CauTraLoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KiemTra extends AppCompatActivity {
    public static ArrayList<CauHoi> listCH;
    public static ArrayList<CauTraLoi> listCTL;
    TextView tvCH,tvCHHT;
    Button btnA,btnB,btnC,btnD,btnNext,btnNopBai,btnCheck,btnBack;
    int recent_index =0;
    ProgressBar pgr;
    String DA_chon ="E";
    int rct_ques = 1;
    ListView lvCheck;
    ArrayAdapter<CauTraLoi> adapterCTL;
    Animation fromleft,fromright,fromtop;

    public static int cauDung = 0;
    public static int thoiGian =0;
    public static String tenDeThi ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_tra);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();

        StartCountDownTime();

        getCauHoi(ChonDeKiemTra.idBaiKiemTra);


        EventClick();
    }

    public void DialogCheck(){
        final Dialog dialogCheck = new Dialog(KiemTra.this);
        dialogCheck.setContentView(R.layout.lyt_checkcautraloi);
        dialogCheck.show();
        dialogCheck.setCanceledOnTouchOutside(false);
        lvCheck = (ListView) dialogCheck.findViewById(R.id.CheckCTL_lv);
        Button btnHuy = (Button) dialogCheck.findViewById(R.id.CheckCTL_btnHuy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCheck.cancel();
            }
        });
        adapterCTL = new ArrayAdapter(KiemTra.this,android.R.layout.simple_list_item_1,listCTL);
        lvCheck.setAdapter(adapterCTL);

        lvCheck.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btnA.setSelected(false);
                btnB.setSelected(false);
                btnC.setSelected(false);
                btnD.setSelected(false);
                recent_index = position;
                rct_ques = position +1;
                DA_chon = listCTL.get(position).getDA_chon();
                HienThiCauHoi();

                switch (DA_chon){
                    case "A":
                        btnA.setSelected(true);
                        break;
                    case "B":
                        btnB.setSelected(true);
                        break;
                    case "C":
                        btnC.setSelected(true);
                        break;
                    case "D":
                        btnD.setSelected(true);
                        break;
                }
                dialogCheck.cancel();
            }
        });

    }

    private void StartCountDownTime() {
        new CountDownTimer(900000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int current = pgr.getProgress();
                if(current>=pgr.getMax()){
                    current=0;
                }
                pgr.setProgress(current+1000);
                thoiGian+=1;
            }

            @Override
            public void onFinish() {
                thoiGian = 900;
                HienThiKetQua();
            }
        }.start();
    }

    private  void HienThiKetQua(){

        CheckKetQua();
        Intent it = new Intent(KiemTra.this,XemKetQuaKiemTra.class);
        startActivity(it);
//        AlertDialog.Builder alert = new AlertDialog.Builder(KiemTra.this);
//        alert.setMessage("Chúc mừng bạn đã hoàn thành bài kiểm tra !\n" +
//                "Số câu trả lời đúng :"+this.CheckKetQua()+"/"+listCH.size());
//        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent it = new Intent(KiemTra.this,ChonDeKiemTra.class);
//                startActivity(it);
//            }
//        });
//
//        alert.show();
    }

    private int CheckKetQua() {
        int soCauDung =0;
        for(int i=0;i<listCTL.size();++i){
            String chon = listCTL.get(i).getDA_chon().toLowerCase();
            String da = listCH.get(i).getDADung().toLowerCase();
            if(chon.equals(da)){
                soCauDung+=1;
                cauDung+=1;
            }
        }
        return soCauDung;
    }

    private  void WriteCTL(){

            if(btnA.isSelected()){
                DA_chon = "A";
            }else{
                if(btnB.isSelected()){
                    DA_chon ="B";
                }
                if(btnC.isSelected()){
                    DA_chon ="C";
                }
                if(btnD.isSelected()){
                    DA_chon ="D";
                }
            }


            listCTL.get(recent_index).setDA_chon(DA_chon+"");

        DA_chon ="E";
    }

    private void EventClick() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(KiemTra.this);
                alert.setMessage("Bạn chưa hoàn thành bài thi. Bạn có muốn thoát hay không ?");
                alert.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent it = new Intent(KiemTra.this,ChonDeKiemTra.class);
                        startActivity(it);
                    }
                });

                alert.setNegativeButton("KHÔNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alert.show();
            }
        });

        btnNopBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(KiemTra.this);
                alert.setMessage("Bạn có chắc chắn muốn nộp bài không ?");
                alert.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        HienThiKetQua();
                    }
                });

                alert.setNegativeButton("KHÔNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alert.show();
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCheck();
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rct_ques==listCH.size()){
                    WriteCTL();
                    HienThiKetQua();
                }else{
                    rct_ques = rct_ques+1;
                    WriteCTL();
                    recent_index+=1;
                    HienThiCauHoi();
                }

            }
        });


        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA.setSelected(!btnA.isSelected());
                btnB.setSelected(false);
                btnC.setSelected(false);
                btnD.setSelected(false);

            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnB.setSelected(!btnB.isSelected());
                btnA.setSelected(false);
                btnC.setSelected(false);
                btnD.setSelected(false);

            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnC.setSelected(!btnC.isSelected());
                btnB.setSelected(false);
                btnA.setSelected(false);
                btnD.setSelected(false);

            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnD.setSelected(!btnD.isSelected());
                btnB.setSelected(false);
                btnC.setSelected(false);
                btnA.setSelected(false);

            }
        });
    }

    private void Init() {
        listCH = new ArrayList<>();
        listCTL = new ArrayList<>();
        tvCH = (TextView) findViewById(R.id.KiemTra_tvCauHoi);
        tvCHHT = (TextView) findViewById(R.id.KiemTra_tvCauHoiHT);

        pgr = (ProgressBar) findViewById(R.id.KiemTra_pgrbar);
        pgr.setMax(900000);

        btnA = (Button) findViewById(R.id.KiemTra_btnA);
        btnB = (Button) findViewById(R.id.KiemTra_btnB);
        btnC = (Button) findViewById(R.id.KiemTra_btnC);
        btnD = (Button) findViewById(R.id.KiemTra_btnD);

        btnNext = (Button) findViewById(R.id.KiemTra_btnCauHoiTiep);
        btnNopBai = (Button) findViewById(R.id.KiemTra_btnNopBai);
        btnCheck = (Button) findViewById(R.id.KiemTra_btnCheck);
        btnNopBai = (Button) findViewById(R.id.KiemTra_btnNopBai);
        btnBack = (Button) findViewById(R.id.KiemTra_btnBack);

        fromleft = AnimationUtils.loadAnimation(KiemTra.this,R.anim.fromleft);
        fromright = AnimationUtils.loadAnimation(KiemTra.this,R.anim.fromright);
        fromtop = AnimationUtils.loadAnimation(KiemTra.this,R.anim.fromtop);

        fromleft.setDuration(1000);
        fromright.setDuration(1000);
        fromtop.setDuration(1000);

        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnD.setVisibility(View.GONE);
    }



    private void HienThiCauHoi(){

        btnA.setVisibility(View.VISIBLE);
        btnB.setVisibility(View.VISIBLE);
        btnC.setVisibility(View.VISIBLE);
        btnD.setVisibility(View.VISIBLE);

        CauHoi ch = listCH.get(recent_index);

        tvCH.setText(ch.getNDCauHoi());
        btnA.setText("A. "+ch.getDA1());
        btnB.setText("B. "+ch.getDA2());
        btnC.setText("C. "+ch.getDA3());
        btnD.setText("D. "+ch.getDA4());

        btnA.setSelected(false);
        btnB.setSelected(false);
        btnC.setSelected(false);
        btnD.setSelected(false);

        btnA.startAnimation(fromleft);
        btnC.startAnimation(fromleft);
        btnB.startAnimation(fromright);
        btnD.startAnimation(fromright);
        tvCH.startAnimation(fromtop);


        tvCHHT.setText(rct_ques+"/"+listCH.size());
    }

    private void getCauHoi(String idBaiKiemTra) {
        Dataservice dataservice = APIService.getService();
        Call<List<CauHoi>> callback = dataservice.getCauHoiTheoDe(idBaiKiemTra);
        callback.enqueue(new Callback<List<CauHoi>>() {
            @Override
            public void onResponse(Call<List<CauHoi>> call, Response<List<CauHoi>> response) {
                ArrayList<CauHoi> l = (ArrayList<CauHoi>) response.body();
                Collections.shuffle(l);
                for(CauHoi ch : l){
                    listCH.add(ch);
                }
                for(int i=0;i<l.size();++i){
                    listCTL.add(new CauTraLoi(l.get(i).getIDCauHoi()+"",l.get(i).getNDCauHoi(),"E"));
                }

                HienThiCauHoi();
            }

            @Override
            public void onFailure(Call<List<CauHoi>> call, Throwable t) {
                Toast.makeText(KiemTra.this,"Get question data failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}