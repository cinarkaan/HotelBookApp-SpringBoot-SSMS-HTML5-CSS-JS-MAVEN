package com.HotelBook.Book.controller;

import com.HotelBook.Book.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html dosyasını döndürür
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        if (loginService.authenticate(username, password)) {
            return "redirect:dashboard"; // Başarılı giriş sonrası yönlendirme
        } else {
            model.addAttribute("error", "Geçersiz kullanıcı adı veya şifre!");
            return "login"; // Hatalı girişte aynı sayfaya dön
        }
    }
}
