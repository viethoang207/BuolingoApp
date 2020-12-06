package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DongTuBQT {

@SerializedName("nt")
@Expose
private String nt;
@SerializedName("qk")
@Expose
private String qk;
@SerializedName("qkpt")
@Expose
private String qkpt;
@SerializedName("nghia")
@Expose
private String nghia;

public String getNt() {
return nt;
}

public void setNt(String nt) {
this.nt = nt;
}

public String getQk() {
return qk;
}

public void setQk(String qk) {
this.qk = qk;
}

public String getQkpt() {
return qkpt;
}

public void setQkpt(String qkpt) {
this.qkpt = qkpt;
}

public String getNghia() {
return nghia;
}

public void setNghia(String nghia) {
this.nghia = nghia;
}

}