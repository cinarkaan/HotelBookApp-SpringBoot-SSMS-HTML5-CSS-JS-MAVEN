package com.HotelBook.Book.controller;

import com.HotelBook.Book.util.RoleServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Controller
public class DashboardController {

    ExecutorService executor = Executors.newFixedThreadPool(1);

    @GetMapping("/dashboard")
    public String showDashboard() {
        executor.submit(() -> new RoleServer(5000));
        return "dashboard"; // dashboard.html sayfasını döndürür

    }


}
    
