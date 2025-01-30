package com.HotelBook.Book.repository;

import com.HotelBook.Book.DTO.CustomerPaymentsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerPaymentsRepository extends JpaRepository<CustomerPaymentsDTO,Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "m.MusteriID,m.Ad,m.Soyad,r.OdemeDurumu,o.OdemeTutari,o.OdemeTarihi,o.OdemeYontemi FROM " +
            "Musteri m inner join Rezervasyon r on r.MusteriID = m.MusteriID " +
            "inner join Odeme o on o.RezervasyonID = r.RezervasyonID;")
    List<CustomerPaymentsDTO> getUserPayments();
}
