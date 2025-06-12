package com.HotelBook.Book.service;

import com.HotelBook.Book.DTO.CustomerReservationDTO;
import com.HotelBook.Book.repository.CustomerReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerReservationDTOService {

    @Autowired(required = true)
    private CustomerReservationRepository customerReservationRepository;

    public List<CustomerReservationDTO> getApplications () {
        return customerReservationRepository.getAllApplications("Beklemede");
    }

    public List<CustomerReservationDTO> getApplicationsByTc (String tc) {
        return customerReservationRepository.getAllApplicationsByTC(tc);
    }



}
