package com.HotelBook.Book.service;

import com.HotelBook.Book.DTO.RoomValidatorDTO;
import com.HotelBook.Book.repository.RoomValidatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomValidatorService {

    @Autowired
    private RoomValidatorRepository roomValidatorRepository;

    public List<RoomValidatorDTO> validatorList() {
        return roomValidatorRepository.validatorList();
    }

}
