package com.HotelBook.Book.controller;

import com.HotelBook.Book.entity.Customer;
import com.HotelBook.Book.entity.CustomerPaymentsDTO;
import com.HotelBook.Book.entity.CustomerReservationDTO;
import com.HotelBook.Book.entity.RoomType;
import com.HotelBook.Book.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerPaymentsDTOService paymentsDTOService;

    @Autowired
    private CustomerReservationDTOService customerReservationDTOService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/payments")
    public ResponseEntity<List<CustomerPaymentsDTO>> getUserDetails() {
        List<CustomerPaymentsDTO> customerPaymentsDTOS = paymentsDTOService.getAllUserPayments();
        return ResponseEntity.ok(customerPaymentsDTOS);
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<CustomerReservationDTO>> getReservations () {
        List<CustomerReservationDTO> customerReservationDTOS = customerReservationDTOService.getApplications();
        return ResponseEntity.ok((customerReservationDTOS));
    }

    @PutMapping("/{ID}")
    public ResponseEntity<CustomerReservationDTO> updateStatus(@PathVariable String ID, @RequestBody CustomerReservationDTO customerReservationDTO) {
        System.out.println("Received User ID: " + ID);
        System.out.println("Received Status : " + customerReservationDTO.getDurum());
        System.out.println("Received Payment : " + customerReservationDTO.getOdemeDurumu());
        System.out.println("Received RoomID : " + customerReservationDTO.getOdaID());
        reservationService.updateReservation(Long.valueOf(ID) , customerReservationDTO);

        if(Objects.equals(customerReservationDTO.getDurum(), "Onaylandı"))
        {
            System.out.println("-----" + customerReservationDTO.getOdaID());
            roomService.updateRoom((long) customerReservationDTO.getOdaID(), RoomType.Dolu);
        }
        return ResponseEntity.ok(customerReservationDTO);
    }

}
