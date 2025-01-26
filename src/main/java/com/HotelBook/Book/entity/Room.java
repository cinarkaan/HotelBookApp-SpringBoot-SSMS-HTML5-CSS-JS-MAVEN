package com.HotelBook.Book.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Oda")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OdaID;
    private String OdaNumarasi;
    private String OdaTipi;
    private int Kapasite;
    private double Fiyat;
    @Enumerated(EnumType.STRING)
    private RoomStatus Durum;
    private String Aciklama;
    private Date OlusturulmaTarihi;

    public Room () {

    }

    public Room(String odaNumarasi, String odaTipi, int kapasite, double fiyat, RoomStatus durum, String aciklama) {
        OdaNumarasi = odaNumarasi;
        OdaTipi = odaTipi;
        Kapasite = kapasite;
        Fiyat = fiyat;
        Durum = durum;
        Aciklama = aciklama;
    }

    public int getOdaID() {
        return OdaID;
    }

    public void setOdaID(int odaID) {
        OdaID = odaID;
    }

    public String getOdaNumarasi() {
        return OdaNumarasi;
    }

    public void setOdaNumarasi(String odaNumarasi) {
        OdaNumarasi = odaNumarasi;
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

    public double getFiyat() {
        return Fiyat;
    }

    public void setFiyat(double fiyat) {
        Fiyat = fiyat;
    }

    public RoomStatus getDurum() {
        return Durum;
    }

    public void setDurum(RoomStatus durum) {
        Durum = durum;
    }

    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String aciklama) {
        Aciklama = aciklama;
    }

    public Date getOlusturmaTarihi() {
        return OlusturulmaTarihi;
    }

    public void setOlusturmaTarihi(Date olusturmaTarihi) {
        OlusturulmaTarihi = olusturmaTarihi;
    }

    @Override
    public String toString() {
        return
            OdaID + "," + OdaNumarasi + "," + OdaTipi + "," + Kapasite + "," + Fiyat;
    }
}
