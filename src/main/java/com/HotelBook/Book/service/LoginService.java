package com.HotelBook.Book.service;

import com.HotelBook.Book.entity.User;
import com.HotelBook.Book.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired(required = true)
    private LoginRepository loginRepository;

    public User authenticate(String kullaniciAdi, String sifre) {
        User user = loginRepository.findByKullaniciAdi(kullaniciAdi);
        if (user != null && user.getSifre().equals(sifre))
            return user; // Kullanıcı doğrulandı
        // Hatalı kullanıcı adı veya şifre
        else {
            return null;
        }
    }

}
