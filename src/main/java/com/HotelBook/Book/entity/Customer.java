package com.HotelBook.Book.entity;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Musteri")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MusteriID;
    private String Ad;
    private String Soyad;
    private String Telefon;
    private String Email;
    private String Adres;
    private String Notlar;
    private String TCNO;
    private Date OlusturulmaTarihi;



    public Customer () {

    }

    public String getNotlar() {
        return Notlar;
    }

    public void setNotlar(String notlar) {
        Notlar = notlar;
    }

    public Customer(String ad, String soyad, String telefon, String email, String adres, String Notes, String TCNO, Date olusturulmaTarihi) {
        Ad = ad;
        Soyad = soyad;
        Telefon = telefon;
        Email = email;
        Adres = adres;
        this.Notlar = Notes;
        this.TCNO = TCNO;
        this.OlusturulmaTarihi = olusturulmaTarihi;
    }

    public int getMusteriID() {
        return MusteriID;
    }

    public void setMusteriID(int musteriID) {
        MusteriID = musteriID;
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

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public String getTCNO() {
        return TCNO;
    }

    public void setTCNO(String TCNO) {
        this.TCNO = TCNO;
    }

    public Date getOlusturulmaTarihi() {
        return OlusturulmaTarihi;
    }

    public void setOlusturulmaTarihi(Date olusturulmaTarihi) {
        OlusturulmaTarihi = olusturulmaTarihi;
    }
}
