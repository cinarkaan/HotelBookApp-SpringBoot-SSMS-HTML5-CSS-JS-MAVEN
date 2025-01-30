package com.HotelBook.Book.repository;

import com.HotelBook.Book.DTO.RoomValidatorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomValidatorRepository extends JpaRepository<RoomValidatorDTO, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM(SELECT OdaID,\n" +
            "\tIIF (CikisTarihi > GETDATE(), 'Dolu', 'Boş') AS RoomStatus\n" +
            "FROM \n" +
            "\tRezervasyon WHERE Durum = 'Onaylandı') as RoomValidator;")
    List<RoomValidatorDTO> validatorList ();


}
