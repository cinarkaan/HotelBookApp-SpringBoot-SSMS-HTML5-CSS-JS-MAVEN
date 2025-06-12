package com.HotelBook.Book.service;

import com.HotelBook.Book.entity.Customer;
import com.HotelBook.Book.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired(required = true)
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer addCustomer (Customer customer) {
        return customerRepository.save(customer);
    }

}
