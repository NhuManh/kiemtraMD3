package org.example;

import java.util.Date;

public class MatBang {
    private String maMatBang;
    private String trangThai;
    private double dienTich;
    private int tang;
    private String loaiMatBang;
    private double giaTien;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    // Constructor
    public MatBang(String maMatBang, String trangThai, double dienTich, int tang, String loaiMatBang, double giaTien, String ngayBatDau, String ngayKetThuc) {
        this.maMatBang = this.maMatBang;
        this.trangThai = this.trangThai;
        this.dienTich = this.dienTich;
        this.tang = this.tang;
        this.loaiMatBang = this.loaiMatBang;
        this.giaTien = this.giaTien;
        this.ngayBatDau = this.ngayBatDau;
        this.ngayKetThuc = this.ngayKetThuc;
    }

    // Getters và Setters
    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getLoaiMatBang() {
        return loaiMatBang;
    }

    public void setLoaiMatBang(String loaiMatBang) {
        this.loaiMatBang = loaiMatBang;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
