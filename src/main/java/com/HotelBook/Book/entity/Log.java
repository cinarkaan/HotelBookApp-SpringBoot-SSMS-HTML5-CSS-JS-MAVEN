package com.HotelBook.Book.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SistemLog")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int LogID;
    private int KullaniciId;
    private String IslemTipi;
    private String IslemDetayi;
    private Date IslemTarihi;

    public Log () {

    }

    public Log(int kullaniciId, String islemTipi, String islemDetayi, Date islemTarihi) {
        KullaniciId = kullaniciId;
        IslemTipi = islemTipi;
        IslemDetayi = islemDetayi;
        IslemTarihi = islemTarihi;
    }

    public int getLogID() {
        return LogID;
    }

    public void setLogID(int logID) {
        LogID = logID;
    }

    public int getKullaniciId() {
        return KullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        KullaniciId = kullaniciId;
    }

    public String getIslemTipi() {
        return IslemTipi;
    }

    public void setIslemTipi(String islemTipi) {
        IslemTipi = islemTipi;
    }

    public String getIslemDetayi() {
        return IslemDetayi;
    }

    public void setIslemDetayi(String IslemDetayi) {
        this.IslemDetayi = IslemDetayi;
    }

    public Date getIslemTarihi() {
        return IslemTarihi;
    }

    public void setIslemTarihi(Date islemTarihi) {
        IslemTarihi = islemTarihi;
    }
}
