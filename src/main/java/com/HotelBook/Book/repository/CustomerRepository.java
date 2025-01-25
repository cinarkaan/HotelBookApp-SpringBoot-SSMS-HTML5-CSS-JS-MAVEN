package com.HotelBook.Book.repository;

import com.HotelBook.Book.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
