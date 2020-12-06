package com.example.buolingo;

import com.example.buolingo.Model.BaiKiemTra;
import com.example.buolingo.Model.CauHoi;
import com.example.buolingo.Model.ChuDeVideo;
import com.example.buolingo.Model.DongTuBQT;
import com.example.buolingo.Model.MauCau;
import com.example.buolingo.Model.TaiKhoan;
import com.example.buolingo.Model.TinTuc;
import com.example.buolingo.Model.TuVung;
import com.example.buolingo.Model.TuVungYeuThich;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET ("getTuVung.php")
    Call<List<TuVung>>getTuVung();

    @GET ("getTuVungDongVat.php")
    Call<List<TuVung>>getTuVungDongVat();

    @GET("getMauCau.php")
    Call<List<MauCau>>getMauCau();

    @GET("getDongTuBQT.php")
    Call<List<DongTuBQT>>getDongTuBQT();

    @GET("getChuDeVideo.php")
    Call<List<ChuDeVideo>>getChuDeVideo();

    @GET("getTinTuc.php")
    Call<List<TinTuc>>getTinTuc();

    @GET("getTaiKhoan.php")
    Call<List<TaiKhoan>>getTaiKhoan();

    @GET("getBaiKiemTra.php")
    Call<List<BaiKiemTra>>getBaiKiemTra();

    @FormUrlEncoded
    @POST("getCauHoiTheoDe.php")
    Call<List<CauHoi>> getCauHoiTheoDe(@Field("IDBaiKiemTra") String idBaiKiemTra);

    @FormUrlEncoded
    @POST("getTuVungYeuThich.php")
    Call<List<TuVungYeuThich>> getTuVungYeuThich(@Field("idNguoiDung") String idNguoiDung);
}
