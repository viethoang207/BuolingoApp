package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MauCau {

@SerializedName("idMauCau")
@Expose
private String idMauCau;
@SerializedName("maucau")
@Expose
private String maucau;
@SerializedName("nghia")
@Expose
private String nghia;
@SerializedName("vidu")
@Expose
private String vidu;

public String getIdMauCau() {
return idMauCau;
}

public void setIdMauCau(String idMauCau) {
this.idMauCau = idMauCau;
}

public String getMaucau() {
return maucau;
}

public void setMaucau(String maucau) {
this.maucau = maucau;
}

public String getNghia() {
return nghia;
}

public void setNghia(String nghia) {
this.nghia = nghia;
}

public String getVidu() {
return vidu;
}

public void setVidu(String vidu) {
this.vidu = vidu;
}

}