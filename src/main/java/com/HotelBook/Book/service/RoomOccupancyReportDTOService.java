package com.HotelBook.Book.service;

import com.HotelBook.Book.entity.RoomOccupancyReportDTO;
import com.HotelBook.Book.repository.OccupancyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomOccupancyReportDTOService {

    @Autowired(required = true)
    private OccupancyReportRepository occupancyReportRepository;

    public List<RoomOccupancyReportDTO> getOccupancys() {
        return occupancyReportRepository.getAllOccupancy();
    }

}
