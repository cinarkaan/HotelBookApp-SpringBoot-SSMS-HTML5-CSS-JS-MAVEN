package com.HotelBook.Book.repository;

import com.HotelBook.Book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<User, String> {
    @Query(nativeQuery= true, value="SELECT * FROM Kullanici WHERE KullaniciAdi = ?")
    User findByKullaniciAdi(String kullaniciAdi);


}
