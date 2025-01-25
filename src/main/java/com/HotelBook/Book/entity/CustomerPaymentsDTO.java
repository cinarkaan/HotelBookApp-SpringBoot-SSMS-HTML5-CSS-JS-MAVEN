package com.HotelBook.Book.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class CustomerPaymentsDTO {

    @Id
    private int MusteriID;
    private String Ad;
    private String Soyad;
    private String OdemeDurumu;
    private double OdemeTutari;
    private Date OdemeTarihi;
    private String OdemeYontemi;


    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }

    public String getOdemeDurumu() {
        return OdemeDurumu;
    }

    public void setOdemeDurumu(String odemeDurumu) {
        OdemeDurumu = odemeDurumu;
    }

    public double getOdemeTutari() {
        return OdemeTutari;
    }

    public void setOdemeTutari(double odemeTutari) {
        OdemeTutari = odemeTutari;
    }

    public Date getOdemeTarihi() {
        return OdemeTarihi;
    }

    public void setOdemeTarihi(Date odemeTarihi) {
        OdemeTarihi = odemeTarihi;
    }

    public String getOdemeYontemi() {
        return OdemeYontemi;
    }

    public void setOdemeYontemi(String odemeYontemi) {
        OdemeYontemi = odemeYontemi;
    }
}
