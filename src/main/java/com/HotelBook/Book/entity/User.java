package com.HotelBook.Book.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Kullanici") // Veritabanındaki tablo adı
public class User {

    @Id
    private int KullaniciID;
    private String KullaniciAdi; // Veritabanındaki kullanıcı adı sütunu
    private String Sifre;       // Veritabanındaki şifre sütunu
    private String Rol;
    private String AdSoyad;
    private String Email;
    private String Telefon;
    private String Durum;
    private Date OlusturulmaTarihi;


    public int getKullaniciID() {
        return KullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        KullaniciID = kullaniciID;
    }

    public String getKullaniciAdi() {
        return KullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        KullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public String getAdSoyad() {
        return AdSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        AdSoyad = adSoyad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
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
