package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaiKiemTra {

@SerializedName("IDBaiKiemTra")
@Expose
private String iDBaiKiemTra;
@SerializedName("TrinhDo")
@Expose
private String trinhDo;
@SerializedName("TenBaiKiemTra")
@Expose
private String tenBaiKiemTra;

public String getIDBaiKiemTra() {
return iDBaiKiemTra;
}

public void setIDBaiKiemTra(String iDBaiKiemTra) {
this.iDBaiKiemTra = iDBaiKiemTra;
}

public String getTrinhDo() {
return trinhDo;
}

public void setTrinhDo(String trinhDo) {
this.trinhDo = trinhDo;
}

public String getTenBaiKiemTra() {
return tenBaiKiemTra;
}

public void setTenBaiKiemTra(String tenBaiKiemTra) {
this.tenBaiKiemTra = tenBaiKiemTra;
}

    @Override
    public String toString() {
        return ""+this.tenBaiKiemTra;
    }
}