package com.example.buolingo.Model;

public class CauTraLoi {
    private String IDCauHoi,CauHoi,DA_chon;

    public CauTraLoi() {
    }

    public CauTraLoi(String IDCauHoi, String cauHoi, String DA_chon) {
        this.IDCauHoi = IDCauHoi;
        this.CauHoi = cauHoi;
        this.DA_chon = DA_chon;
    }

    public String getIDCauHoi() {
        return IDCauHoi;
    }

    public void setIDCauHoi(String IDCauHoi) {
        this.IDCauHoi = IDCauHoi;
    }

    public String getCauHoi() {
        return CauHoi;
    }

    public void setCauHoi(String cauHoi) {
        CauHoi = cauHoi;
    }

    public String getDA_chon() {
        return DA_chon;
    }

    public void setDA_chon(String DA_chon) {
        this.DA_chon = DA_chon;
    }

    @Override
    public String toString() {
        String da ="";
        if(this.DA_chon.toLowerCase().equals("e")){
            da ="";
        }else{
            da = this.DA_chon;
        }
        return "\n\n"+this.CauHoi+"\nĐáp án chọn : "+da+"\n\n";
    }
}
