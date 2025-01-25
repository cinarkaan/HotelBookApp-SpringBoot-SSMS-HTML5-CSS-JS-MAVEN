package com.HotelBook.Book.service;

import com.HotelBook.Book.entity.Payments;
import com.HotelBook.Book.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired(required = true)
    private PaymentRepository paymentRepository;

    public Payments addPayment(Payments payments) {
        return paymentRepository.save(payments);
    }

}
