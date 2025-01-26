package com.HotelBook.Book.controller;

import com.HotelBook.Book.entity.RoomOccupancyReportDTO;
import com.HotelBook.Book.service.RoomOccupancyReportDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OccupancyReportController {

    @Autowired(required = true)
    private RoomOccupancyReportDTOService roomOccupancyReportDTOService;


    @GetMapping("/occupancy")
    public ResponseEntity<List<RoomOccupancyReportDTO>> getIncomes() {
        List<RoomOccupancyReportDTO> roomOccupancyReportDTOS = roomOccupancyReportDTOService.getOccupancys();
        return ResponseEntity.ok(roomOccupancyReportDTOS);
    }


}
