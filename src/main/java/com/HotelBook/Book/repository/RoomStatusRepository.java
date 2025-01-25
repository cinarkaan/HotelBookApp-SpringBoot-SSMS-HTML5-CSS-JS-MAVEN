package com.HotelBook.Book.repository;

import com.HotelBook.Book.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomStatusRepository extends JpaRepository<Room,String> {
    @Query(nativeQuery= true, value="SELECT * FROM ODA WHERE Durum = ?")
    List<Room> findByDurum(String Durum);
}
