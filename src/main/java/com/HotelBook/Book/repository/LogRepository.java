package com.HotelBook.Book.repository;

import com.HotelBook.Book.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Long> {
}
