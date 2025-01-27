package com.HotelBook.Book.controller;

import com.HotelBook.Book.entity.RoomStatus;
import com.HotelBook.Book.entity.RoomValidatorDTO;
import com.HotelBook.Book.service.RoomService;
import com.HotelBook.Book.service.RoomValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private RoomValidatorService roomValidatorService;

    @Autowired
    private RoomService roomService;

    public void roomValidator () {
        List<RoomValidatorDTO> approved = roomValidatorService.validatorList();
        if (approved.size() > 0)
            approved.forEach(a -> roomService.updateRoom((long)a.getOdaID(), RoomStatus.valueOf(a.getRoomStatus())));
        System.out.println("Room status has been updated successfully");
    }

    @GetMapping("/")
    public String hello(){
        roomValidator();
        return "home";
    }

}