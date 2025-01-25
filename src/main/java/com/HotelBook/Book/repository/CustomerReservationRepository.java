package com.HotelBook.Book.repository;

import com.HotelBook.Book.entity.CustomerReservationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerReservationRepository extends JpaRepository<CustomerReservationDTO,String> {

    @Query(nativeQuery = true , value = "SELECT \n" +
            "\tm.MusteriID,r.RezervasyonID,o.OdaID,m.Ad,m.Soyad,o.OdaNumarasi,r.GirisTarihi,r.CikisTarihi,r.OdemeDurumu,r.Durum \n" +
            "\t\tFROM Musteri m \n" +
            "\t\t\tinner join Rezervasyon r on m.MusteriID = r.MusteriID \n" +
            "\t\t\t\tinner join Oda o on o.OdaID = r.OdaID where r.Durum = ?;")
    List<CustomerReservationDTO> getAllApplications(String Durum);

}
