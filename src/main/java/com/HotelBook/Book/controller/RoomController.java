package com.HotelBook.Book.controller;

import com.HotelBook.Book.entity.Room;
import com.HotelBook.Book.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired(required = true)
    private RoomService roomService;

    @GetMapping("/")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> users = roomService.allRooms();
        return ResponseEntity.ok(users);
    }

}
