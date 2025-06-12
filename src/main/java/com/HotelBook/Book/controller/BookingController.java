package com.HotelBook.Book.controller;

import com.HotelBook.Book.entity.Customer;
import com.HotelBook.Book.entity.Payments;
import com.HotelBook.Book.entity.Reservations;
import com.HotelBook.Book.entity.Room;
import com.HotelBook.Book.service.CustomerService;
import com.HotelBook.Book.service.PaymentService;
import com.HotelBook.Book.service.ReservationService;
import com.HotelBook.Book.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class BookingController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String populateList(Model model) {
        List<String> availableRooms = new ArrayList<String>();
        for (Room r: roomService.availableRoom("Boş")) {
            availableRooms.add(r.toString());
        }
        System.out.println(availableRooms.size());
        model.addAttribute("rooms", availableRooms);
        return "booking";
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

    @PostMapping("/make/booking")
    public String getReservation (
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String notes,
            @RequestParam String tc,
            @RequestParam String availableRoom,
            @RequestParam String checkIn,
            @RequestParam String checkOut,
            @RequestParam String PaymentType, Model model) throws ParseException {
        if (Objects.equals(availableRoom, "0")){
            model.addAttribute("error", "Please Select A Valid Room !");
            return "booking";
        }
            else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            List<String> roomOptions = Arrays.stream(availableRoom.split(",")).toList();
            Customer customer = new Customer(name,surname,email,phone,address,notes,tc,getDateCurrent());
            Customer addedCustomer = customerService.addCustomer(customer);
            Reservations reservations = new Reservations(customer.getMusteriID(), Integer.parseInt(roomOptions.get(0)), simpleDateFormat.parse(checkIn),simpleDateFormat.parse(checkOut),Integer.parseInt(roomOptions.get(3)),"Ödenmedi","Beklemede",getDateCurrent());
            Reservations addedReservation = reservationService.addReservation(reservations);
            Payments payments = new Payments(reservations.getRezervasyonID(),Double.parseDouble(roomOptions.get(4)),PaymentType,getDateCurrent());
            paymentService.addPayment(payments);
            return "redirect:/";
        }

    }

}
