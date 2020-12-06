package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CauHoi {

@SerializedName("IDCauHoi")
@Expose
private String iDCauHoi;
@SerializedName("IDBaiKiemTra")
@Expose
private String iDBaiKiemTra;
@SerializedName("NDCauHoi")
@Expose
private String nDCauHoi;
@SerializedName("DA1")
@Expose
private String dA1;
@SerializedName("DA2")
@Expose
private String dA2;
@SerializedName("DA3")
@Expose
private String dA3;
@SerializedName("DA4")
@Expose
private String dA4;
@SerializedName("DA_Dung")
@Expose
private String dADung;

public String getIDCauHoi() {
return iDCauHoi;
}

public void setIDCauHoi(String iDCauHoi) {
this.iDCauHoi = iDCauHoi;
}

public String getIDBaiKiemTra() {
return iDBaiKiemTra;
}

public void setIDBaiKiemTra(String iDBaiKiemTra) {
this.iDBaiKiemTra = iDBaiKiemTra;
}

public String getNDCauHoi() {
return nDCauHoi;
}

public void setNDCauHoi(String nDCauHoi) {
this.nDCauHoi = nDCauHoi;
}

public String getDA1() {
return dA1;
}

public void setDA1(String dA1) {
this.dA1 = dA1;
}

public String getDA2() {
return dA2;
}

public void setDA2(String dA2) {
this.dA2 = dA2;
}

public String getDA3() {
return dA3;
}

public void setDA3(String dA3) {
this.dA3 = dA3;
}

public String getDA4() {
return dA4;
}

public void setDA4(String dA4) {
this.dA4 = dA4;
}

public String getDADung() {
return dADung;
}

public void setDADung(String dADung) {
this.dADung = dADung;
}

}