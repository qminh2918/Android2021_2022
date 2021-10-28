package com.example.bai2;

import android.text.Editable;

public class NhanVien {
    public Editable name;
    public Editable ngaysinh;
    public Editable email;

    public NhanVien() {
    }

    public NhanVien(Editable name, Editable ngaysinh, Editable email) {
        this.name = name;
        this.ngaysinh = ngaysinh;
        this.email = email;
    }

    public Editable getName() {
        return name;
    }

    public void setName(Editable name) {
        this.name = name;
    }

    public Editable getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Editable ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Editable getEmail() {
        return email;
    }

    public void setEmail(Editable email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "name='" + name + '\'' +
                ", ngaysinh='" + ngaysinh + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
