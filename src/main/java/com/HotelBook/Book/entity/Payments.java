package com.HotelBook.Book.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Odeme")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OdemeID;
    private int RezervasyonID;
    private double OdemeTutari;
    private Date OdemeTarihi;
    private String OdemeYontemi;

    public Payments() {

    }

    public Payments(int rezervasyonID, double odemeTutari, String odemeYontemi,Date odemeTarihi) {
        RezervasyonID = rezervasyonID;
        OdemeTutari = odemeTutari;
        OdemeYontemi = odemeYontemi;
        this.OdemeTarihi = odemeTarihi;
    }

    public int getOdemeID() {
        return OdemeID;
    }

    public void setOdemeID(int odemeID) {
        OdemeID = odemeID;
    }

    public int getRezervasyonID() {
        return RezervasyonID;
    }

    public void setRezervasyonID(int rezervasyonID) {
        RezervasyonID = rezervasyonID;
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
