package com.HotelBook.Book.controller;

import com.HotelBook.Book.entity.Log;
import com.HotelBook.Book.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/logs")
    public ResponseEntity<List<Log>> getAllUsers() {
        List<Log> users = logService.getAllLogs();
        return ResponseEntity.ok(users);
    }


}
