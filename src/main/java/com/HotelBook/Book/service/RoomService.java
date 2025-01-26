package com.HotelBook.Book.service;

import com.HotelBook.Book.entity.Room;
import com.HotelBook.Book.entity.RoomStatus;
import com.HotelBook.Book.repository.RoomRepository;
import com.HotelBook.Book.repository.RoomStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired(required = true)
    private RoomStatusRepository roomStatusRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> availableRoom(String Durum) {
        List<Room> room = roomStatusRepository.findByDurum(Durum);
        return room;
    }

    public List<Room> allRooms(){
        List<Room> roomList = roomStatusRepository.findAll();
        return roomList;
    }

    public Room updateRoom (Long ID , RoomStatus roomStatus) {
        Optional<Room> roomOptional = roomRepository.findById(ID);
        System.out.println(roomOptional.isPresent() + "-----");
        if (roomOptional.isPresent()) {
            roomOptional.get().setDurum(RoomStatus.Dolu);
            return roomRepository.save(roomOptional.get());
        } else {
            throw new RuntimeException("User not found");
        }

    }

}
