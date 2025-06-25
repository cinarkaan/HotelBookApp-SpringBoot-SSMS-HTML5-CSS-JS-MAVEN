package com.HotelBook.Book.controller;

import com.HotelBook.Book.DTO.CustomerReservationDTO;
import com.HotelBook.Book.entity.Reservations;
import com.HotelBook.Book.service.CustomerReservationDTOService;
import com.HotelBook.Book.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Controller
public class CustomerInquiryController {

    private String TC = "";
    private List<CustomerReservationDTO> customerReservationDTO;

    @Autowired
    private CustomerReservationDTOService customerReservationDTOService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/inquiry")
    public String page () {
        return  "customer";
    }

    @PostMapping("/result")
    public String resultPage (@RequestParam("TC") String tc, Model model)
    {
        customerReservationDTO = customerReservationDTOService.getApplicationsByTc(tc);
        if (customerReservationDTO.size() != 0)
        {
            for (CustomerReservationDTO c: customerReservationDTO) {
                model.addAttribute("Name",c.getAd());
                model.addAttribute("Surname",c.getSoyad());
                model.addAttribute("CustomerId",c.getMusteriID());
                model.addAttribute("ReservationId",c.getRezervasyonID());
                model.addAttribute("EnterDate",c.getGirisTarihi().toString());
                model.addAttribute("DepartureDate",c.getCikisTarihi().toString());
                model.addAttribute("RoomNo",c.getOdaNumarasi());
                model.addAttribute("Status",c.getDurum());
            }
            TC = tc;
            return  "result";
        }
        else {
            model.addAttribute("error", "TC no yanlış veya hatalı !");
            return  "customer";
        }

    }

    @PostMapping("/rollback")
    public String rollback (Model model) {
        int rId =  customerReservationDTO.get(0).getRezervasyonID();
        if (customerReservationDTO.get(0).getDurum().equals("İptal Edildi")) {
            model.addAttribute("info", "Your reservation already has been canceled!!!");
        }
        else if (customerReservationDTO.get(0).getDurum().equals("Onaylandı")) {
            model.addAttribute("info", "Your reservation already has been approved!!!");
        }
        else{
            customerReservationDTO.get(0).setDurum("İptal Edildi");
            Reservations reservations = reservationService.updateReservation(Long.valueOf(rId),customerReservationDTO.get(0));
            model.addAttribute("info", "Your reservation has been canceled...");
        }
        for (CustomerReservationDTO c: customerReservationDTO) {
            model.addAttribute("Name",c.getAd());
            model.addAttribute("Surname",c.getSoyad());
            model.addAttribute("CustomerId",c.getMusteriID());
            model.addAttribute("ReservationId",c.getRezervasyonID());
            model.addAttribute("EnterDate",c.getGirisTarihi().toString());
            model.addAttribute("DepartureDate",c.getCikisTarihi().toString());
            model.addAttribute("RoomNo",c.getOdaNumarasi());
            model.addAttribute("Status",c.getDurum());
        }
        return "result";
    }

    @PostMapping("/postpone")
    public String postpone (@RequestParam  String checkIn, @RequestParam String checkOut , Model model) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        int rId =  customerReservationDTO.get(0).getRezervasyonID();
        if (Objects.equals(checkIn, checkOut))
            model.addAttribute("info", "Both of two date is not to be same each other!!!");
        else if (customerReservationDTO.get(0).getDurum().equals("İptal Edildi")) {
            model.addAttribute("info", "Your reservation already has been canceled!!!");
        }
        else if (customerReservationDTO.get(0).getDurum().equals("Onaylandı")) {
            model.addAttribute("info", "Your reservation already has been approved!!!");
        }
        else{
            customerReservationDTO.get(0).setGirisTarihi(simpleDateFormat.parse(checkIn));
            customerReservationDTO.get(0).setCikisTarihi(simpleDateFormat.parse(checkOut));
            Reservations reservations = reservationService.updateReservation(Long.valueOf(rId),customerReservationDTO.get(0));
            model.addAttribute("info", "Your reservation has been updated...");
        }
        for (CustomerReservationDTO c: customerReservationDTO) {
            model.addAttribute("Name",c.getAd());
            model.addAttribute("Surname",c.getSoyad());
            model.addAttribute("CustomerId",c.getMusteriID());
            model.addAttribute("ReservationId",c.getRezervasyonID());
            model.addAttribute("EnterDate",c.getGirisTarihi().toString());
            model.addAttribute("DepartureDate",c.getCikisTarihi().toString());
            model.addAttribute("RoomNo",c.getOdaNumarasi());
            model.addAttribute("Status",c.getDurum());
        }
        return "result";
    }






}
