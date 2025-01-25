package com.HotelBook.Book.repository;

import com.HotelBook.Book.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payments, Long> {

}
