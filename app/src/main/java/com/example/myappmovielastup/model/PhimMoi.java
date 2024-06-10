package com.example.myappmovielastup.model;

import java.io.Serializable;

public class PhimMoi implements Serializable {
    int id;
    String ten;
    String hinhanh;
    String daodien;
    String dienvien;
    String thoiluong;
    String ngonngu;
    int theloaiid;
    String mota;
    String giave = "60000";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getDaodien() {
        return daodien;
    }

    public void setDaodien(String daodien) {
        this.daodien = daodien;
    }

    public String getDienvien() {
        return dienvien;
    }

    public void setDienvien(String dienvien) {
        this.dienvien = dienvien;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getNgonngu() {
        return ngonngu;
    }

    public void setNgonngu(String ngonngu) {
        this.ngonngu = ngonngu;
    }

    public int getTheloaiid() {
        return theloaiid;
    }

    public void setTheloaiid(int theloaiid) {
        this.theloaiid = theloaiid;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGiave() {
        return giave;
    }

    public void setGiave(String giave) {
        this.giave = giave;
    }
}
