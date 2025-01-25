package com.HotelBook.Book.repository;

import com.HotelBook.Book.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservations, Long> {

}
