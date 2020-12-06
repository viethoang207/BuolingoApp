package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaiKhoan {

@SerializedName("ID")
@Expose
private String iD;
@SerializedName("PW")
@Expose
private String pW;
@SerializedName("HoTen")
@Expose
private String hoTen;
@SerializedName("GioiTinh")
@Expose
private String gioiTinh;

public String getID() {
return iD;
}

public void setID(String iD) {
this.iD = iD;
}

public String getPW() {
return pW;
}

public void setPW(String pW) {
this.pW = pW;
}

public String getHoTen() {
return hoTen;
}

public void setHoTen(String hoTen) {
this.hoTen = hoTen;
}

public String getGioiTinh() {
return gioiTinh;
}

public void setGioiTinh(String gioiTinh) {
this.gioiTinh = gioiTinh;
}

}