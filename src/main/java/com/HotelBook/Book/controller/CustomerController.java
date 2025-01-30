package com.HotelBook.Book.controller;

import com.HotelBook.Book.DTO.CustomerPaymentsDTO;
import com.HotelBook.Book.DTO.CustomerReservationDTO;
import com.HotelBook.Book.entity.*;
import com.HotelBook.Book.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LogService logService;

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
    public ResponseEntity<CustomerReservationDTO> updateStatus(@PathVariable String ID, @RequestBody CustomerReservationDTO customerReservationDTO) throws ParseException {
        System.out.println("Received User ID: " + ID);
        System.out.println("Received Status : " + customerReservationDTO.getDurum());
        System.out.println("Received Payment : " + customerReservationDTO.getOdemeDurumu());
        System.out.println("Received RoomID : " + customerReservationDTO.getOdaID());
        reservationService.updateReservation(Long.valueOf(ID) , customerReservationDTO);
        if(Objects.equals(customerReservationDTO.getDurum(), "Onaylandı"))
        {
            Log log = new Log(LoginController.userID,"Güncelleme",ID + " id'li rezervasyonu onaylandı",getDateCurrent());
            roomService.updateRoom((long) customerReservationDTO.getOdaID(), RoomStatus.Dolu);
            logService.addLogRecord(log);
        } else if (Objects.equals(customerReservationDTO.getDurum(), "İptal Edildi")) {
            Log log = new Log(LoginController.userID,"Güncelleme",ID + " id'li rezervasyonu iptal edildi",getDateCurrent());
            logService.addLogRecord(log);
        }
        return ResponseEntity.ok(customerReservationDTO);
    }

    private String getDateTime () {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    private Date getDateCurrent() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.parse(getDateTime());
    }

}
