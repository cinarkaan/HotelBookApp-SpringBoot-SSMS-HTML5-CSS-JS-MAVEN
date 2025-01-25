package com.HotelBook.Book.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "SistemLog")
public class Log {

    @Id
    private int LogID;
    private int KullaniciId;
    private String IslemTipi;
    private String IslemDetayi;
    private Date IslemTarihi;

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
