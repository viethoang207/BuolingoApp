package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TuVungYeuThich {

@SerializedName("idTu")
@Expose
private String idTu;
@SerializedName("idNguoiDung")
@Expose
private String idNguoiDung;
@SerializedName("Anh")
@Expose
private String anh;
@SerializedName("Tu")
@Expose
private String tu;
@SerializedName("Nghia")
@Expose
private String nghia;

    public TuVungYeuThich(String idTu, String idNguoiDung, String anh, String tu, String nghia) {
        this.idTu = idTu;
        this.idNguoiDung = idNguoiDung;
        this.anh = anh;
        this.tu = tu;
        this.nghia = nghia;
    }

    public String getIdTu() {
return idTu;
}

public void setIdTu(String idTu) {
this.idTu = idTu;
}

public String getIdNguoiDung() {
return idNguoiDung;
}

public void setIdNguoiDung(String idNguoiDung) {
this.idNguoiDung = idNguoiDung;
}

public String getAnh() {
return anh;
}

public void setAnh(String anh) {
this.anh = anh;
}

public String getTu() {
return tu;
}

public void setTu(String tu) {
this.tu = tu;
}

public String getNghia() {
return nghia;
}

public void setNghia(String nghia) {
this.nghia = nghia;
}


    @Override
    public String toString() {
        return "TuVungYeuThich{" +
                "idTu='" + idTu + '\'' +
                ", idNguoiDung='" + idNguoiDung + '\'' +
                ", anh='" + anh + '\'' +
                ", tu='" + tu + '\'' +
                ", nghia='" + nghia + '\'' +
                '}';
    }
}