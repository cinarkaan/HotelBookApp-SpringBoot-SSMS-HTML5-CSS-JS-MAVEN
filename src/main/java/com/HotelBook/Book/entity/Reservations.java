package com.HotelBook.Book.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Rezervasyon")
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RezervasyonID;
    private int MusteriID;
    private int OdaID;
    private Date GirisTarihi;
    private Date CikisTarihi;
    private int KisiSayisi;
    private String OdemeDurumu;
    private String Durum;
    private Date OlusturulmaTarihi;

    public Reservations () {

    }

    public Reservations(int musteriID, int odaID, Date girisTarihi, Date cikisTarihi, int kisiSayisi, String odemeDurumu, String durum, Date OlusturulmaTarihi) {
        MusteriID = musteriID;
        OdaID = odaID;
        GirisTarihi = girisTarihi;
        CikisTarihi = cikisTarihi;
        KisiSayisi = kisiSayisi;
        OdemeDurumu = odemeDurumu;
        Durum = durum;
        this.OlusturulmaTarihi = OlusturulmaTarihi;
    }

    public int getRezervasyonID() {
        return RezervasyonID;
    }

    public void setRezervasyonID(int rezervasyonID) {
        RezervasyonID = rezervasyonID;
    }

    public int getMusteriID() {
        return MusteriID;
    }

    public void setMusteriID(int musteriID) {
        MusteriID = musteriID;
    }

    public int getOdaID() {
        return OdaID;
    }

    public void setOdaID(int odaID) {
        OdaID = odaID;
    }

    public Date getGirisTarihi() {
        return GirisTarihi;
    }

    public void setGirisTarihi(Date girisTarihi) {
        GirisTarihi = girisTarihi;
    }

    public Date getCikisTarihi() {
        return CikisTarihi;
    }

    public void setCikisTarihi(Date cikisTarihi) {
        CikisTarihi = cikisTarihi;
    }

    public int getKisiSayisi() {
        return KisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        KisiSayisi = kisiSayisi;
    }

    public String getOdemeDurumu() {
        return OdemeDurumu;
    }

    public void setOdemeDurumu(String odemeDurumu) {
        OdemeDurumu = odemeDurumu;
    }

    public String getDurum() {
        return Durum;
    }

    public void setDurum(String durum) {
        Durum = durum;
    }

    public Date getOlusturulmaTarihi() {
        return OlusturulmaTarihi;
    }

    public void setOlusturulmaTarihi(Date olusturulmaTarihi) {
        OlusturulmaTarihi = olusturulmaTarihi;
    }

}
