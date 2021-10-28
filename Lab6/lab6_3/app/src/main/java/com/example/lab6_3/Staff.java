package com.example.lab6_3;

public class Staff {
    int id;
    String ten,sdt,gtinh;

    public Staff(int id) {
        this.id = id;
    }

    public Staff(int id, String ten, String sdt, String gtinh) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.gtinh = gtinh;
    }

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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGtinh() {
        return gtinh;
    }

    public void setGtinh(String gtinh) {
        this.gtinh = gtinh;
    }
}
