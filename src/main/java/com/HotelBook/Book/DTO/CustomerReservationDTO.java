package com.HotelBook.Book.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class CustomerReservationDTO {

    private int MusteriID;
    @Id
    private int RezervasyonID;
    private int OdaID;
    private String Ad;
    private String Soyad;
    private String OdaNumarasi;
    private Date GirisTarihi;
    private Date CikisTarihi;
    private String OdemeDurumu;
    private String Durum;

    public int getMusteriID() {
        return MusteriID;
    }

    public void setMusteriID(int musteriID) {
        MusteriID = musteriID;
    }

    public int getRezervasyonID() {
        return RezervasyonID;
    }

    public void setRezervasyonID(int rezervasyonID) {
        RezervasyonID = rezervasyonID;
    }

    public int getOdaID() {
        return OdaID;
    }

    public void setOdaID(int odaID) {
        OdaID = odaID;
    }

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

    public String getOdaNumarasi() {
        return OdaNumarasi;
    }

    public void setOdaNumarasi(String odaNumarasi) {
        OdaNumarasi = odaNumarasi;
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
}
