package com.HotelBook.Book.service;

import com.HotelBook.Book.DTO.CustomerPaymentsDTO;
import com.HotelBook.Book.repository.CustomerPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerPaymentsDTOService {

    @Autowired(required = true)
    private CustomerPaymentsRepository customerPaymentsRepository;

    public List<CustomerPaymentsDTO> getAllUserPayments () {
        return customerPaymentsRepository.getUserPayments();
    }

}
