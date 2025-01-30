package com.HotelBook.Book.repository;

import com.HotelBook.Book.DTO.RoomOccupancyReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OccupancyReportRepository extends JpaRepository<RoomOccupancyReportDTO, Long> {
    @Query(nativeQuery = true, value = "SELECT \n" +
            "\tDolulukRaporu.RaporID,Oda.OdaTipi,Oda.Kapasite,DolulukRaporu.Tarih,DolulukRaporu.DolulukDurumu,DolulukRaporu.RezervasyonSayisi\n" +
            "\t\tFROM DolulukRaporu INNER JOIN Oda ON DolulukRaporu.OdaID = Oda.OdaID;")
    List<RoomOccupancyReportDTO> getAllOccupancy();
}
