package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TuVung {

@SerializedName("idTL")
@Expose
private String idTL;
@SerializedName("tu")
@Expose
private String tu;
@SerializedName("nghia")
@Expose
private String nghia;
@SerializedName("anh")
@Expose
private String anh;

public String getIdTL() {
return idTL;
}

public void setIdTL(String idTL) {
this.idTL = idTL;
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

public String getAnh() {
return anh;
}

public void setAnh(String anh) {
this.anh = anh;
}

}