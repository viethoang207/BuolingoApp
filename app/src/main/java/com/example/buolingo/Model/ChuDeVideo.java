package com.example.buolingo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDeVideo {

@SerializedName("idChuDeVideo")
@Expose
private String idChuDeVideo;
@SerializedName("tenChuDeVideo")
@Expose
private String tenChuDeVideo;
@SerializedName("noiDungChuDe")
@Expose
private String noiDungChuDe;
@SerializedName("idYoutube")
@Expose
private String idYoutube;
@SerializedName("fileLyThuyet")
@Expose
private String fileLyThuyet;

public String getIdChuDeVideo() {
return idChuDeVideo;
}

public void setIdChuDeVideo(String idChuDeVideo) {
this.idChuDeVideo = idChuDeVideo;
}

public String getTenChuDeVideo() {
return tenChuDeVideo;
}

public void setTenChuDeVideo(String tenChuDeVideo) {
this.tenChuDeVideo = tenChuDeVideo;
}

public String getNoiDungChuDe() {
return noiDungChuDe;
}

public void setNoiDungChuDe(String noiDungChuDe) {
this.noiDungChuDe = noiDungChuDe;
}

public String getIdYoutube() {
return idYoutube;
}

public void setIdYoutube(String idYoutube) {
this.idYoutube = idYoutube;
}

public String getFileLyThuyet() {
return fileLyThuyet;
}

public void setFileLyThuyet(String fileLyThuyet) {
this.fileLyThuyet = fileLyThuyet;
}

}