package com.HotelBook.Book.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class RoomOccupancyReportDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RaporID;
    private String OdaTipi;
    private int Kapasite;
    private Date Tarih;
    private String DolulukDurumu;
    private int RezervasyonSayisi;

    public int getRaporID() {
        return RaporID;
    }

    public void setRaporID(int raporID) {
        RaporID = raporID;
    }

    public String getOdaTipi() {
        return OdaTipi;
    }

    public void setOdaTipi(String odaTipi) {
        OdaTipi = odaTipi;
    }

    public int getKapasite() {
        return Kapasite;
    }

    public void setKapasite(int kapasite) {
        Kapasite = kapasite;
    }

    public Date getTarih() {
        return Tarih;
    }

    public void setTarih(Date tarih) {
        Tarih = tarih;
    }

    public String getRoomStatus() {
        return DolulukDurumu;
    }

    public void setRoomStatus(String DolulukDurumu) {
        this.DolulukDurumu = DolulukDurumu;
    }

    public int getRezervasyonSayisi() {
        return RezervasyonSayisi;
    }

    public void setRezervasyonSayisi(int rezervasyonSayisi) {
        RezervasyonSayisi = rezervasyonSayisi;
    }
}
