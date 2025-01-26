package com.HotelBook.Book.service;

import com.HotelBook.Book.entity.Log;
import com.HotelBook.Book.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired(required = true)
    private LogRepository logRepository;


    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public Log addLogRecord (Log log) {
        return logRepository.save(log);
    }

}
