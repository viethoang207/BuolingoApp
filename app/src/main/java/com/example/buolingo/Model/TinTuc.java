package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TinTuc {

@SerializedName("IDTinTuc")
@Expose
private String iDTinTuc;
@SerializedName("LoaiTinTuc")
@Expose
private String loaiTinTuc;
@SerializedName("NDTinTuc")
@Expose
private String nDTinTuc;
@SerializedName("URL")
@Expose
private String uRL;
@SerializedName("Anh")
@Expose
private String anh;

public String getIDTinTuc() {
return iDTinTuc;
}

public void setIDTinTuc(String iDTinTuc) {
this.iDTinTuc = iDTinTuc;
}

public String getLoaiTinTuc() {
return loaiTinTuc;
}

public void setLoaiTinTuc(String loaiTinTuc) {
this.loaiTinTuc = loaiTinTuc;
}

public String getNDTinTuc() {
return nDTinTuc;
}

public void setNDTinTuc(String nDTinTuc) {
this.nDTinTuc = nDTinTuc;
}

public String getURL() {
return uRL;
}

public void setURL(String uRL) {
this.uRL = uRL;
}

public String getAnh() {
return anh;
}

public void setAnh(String anh) {
this.anh = anh;
}

}