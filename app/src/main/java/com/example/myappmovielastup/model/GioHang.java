package com.example.myappmovielastup.model;

public class GioHang {
    int idphim;
    String tenphim;
    String hinhphim;
    int soluong;
    long gia;

    public GioHang() {
    }

    public int getIdphim() {
        return idphim;
    }

    public void setIdphim(int idphim) {
        this.idphim = idphim;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public String getHinhphim() {
        return hinhphim;
    }

    public void setHinhphim(String hinhphim) {
        this.hinhphim = hinhphim;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public long getGia() {
        return 60000;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }
}
