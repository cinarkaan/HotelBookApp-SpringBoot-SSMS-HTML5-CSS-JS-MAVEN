package com.HotelBook.Book.controller;

import com.HotelBook.Book.DTO.CustomerReservationDTO;
import com.HotelBook.Book.service.CustomerReservationDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerInquiryController {

    @Autowired
    private CustomerReservationDTOService customerReservationDTOService;

    @GetMapping("/inquiry")
    public String page () {
        return  "customer";
    }

    @PostMapping("/result")
    public String resultPage (@RequestParam("TC") String tc, Model model)
    {
        List<CustomerReservationDTO> list = customerReservationDTOService.getApplicationsByTc(tc);
        if (list.size() != 0)
        {
            for (CustomerReservationDTO c: list) {
                model.addAttribute("Name",c.getAd());
                model.addAttribute("Surname",c.getSoyad());
                model.addAttribute("EnterDate",c.getGirisTarihi().toString());
                model.addAttribute("DepartureDate",c.getCikisTarihi().toString());
                model.addAttribute("RoomNo",c.getOdaNumarasi());
                model.addAttribute("Status",c.getDurum());
            }
            return  "result";
        }
        else {
            model.addAttribute("error", "TC no yanlış veya hatalı !");
            return  "customer";
        }

    }



}
