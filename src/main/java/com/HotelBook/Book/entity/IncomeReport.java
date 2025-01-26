package com.HotelBook.Book.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "GelirRaporu")
public class IncomeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RaporID;
    private Date Tarih;
    private double ToplamGelir;
    private int RezervasyonSayisi;
    private Date OlusturulmaTarihi;

    public IncomeReport () {

    }

    public int getRaporID() {
        return RaporID;
    }

    public void setRaporID(int raporID) {
        RaporID = raporID;
    }

    public Date getTarih() {
        return Tarih;
    }

    public void setTarih(Date tarih) {
        Tarih = tarih;
    }

    public double getToplamGelir() {
        return ToplamGelir;
    }

    public void setToplamGelir(double toplamGelir) {
        ToplamGelir = toplamGelir;
    }

    public int getRezervasyonSayisi() {
        return RezervasyonSayisi;
    }

    public void setRezervasyonSayisi(int rezervasyonSayisi) {
        RezervasyonSayisi = rezervasyonSayisi;
    }

    public Date getOlusturlmaTarihi() {
        return OlusturulmaTarihi;
    }

    public void setOlusturlmaTarihi(Date olusturlmaTarihi) {
        OlusturulmaTarihi = olusturlmaTarihi;
    }
}
