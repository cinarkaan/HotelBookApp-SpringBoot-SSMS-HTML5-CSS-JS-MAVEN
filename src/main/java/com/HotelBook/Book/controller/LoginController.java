package com.HotelBook.Book.controller;

import com.HotelBook.Book.entity.Log;
import com.HotelBook.Book.entity.User;
import com.HotelBook.Book.service.LogService;
import com.HotelBook.Book.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController {

    public static int userID;

    @Autowired
    private LoginService loginService;

    @Autowired
    private LogService logService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html dosyasını döndürür
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) throws ParseException {
        User user = loginService.authenticate(username,password);
        if (user != null) {
            userID = user.getKullaniciID();
            Log log = new Log(user.getKullaniciID(),"Giriş",username + " adlı kullanıcı sisteme giriş yaptı",getDateCurrent());
            logService.addLogRecord(log);
            return "redirect:dashboard"; // Başarılı giriş sonrası yönlendirme
        } else {
            model.addAttribute("error", "Either your id or password is not valid !");
            return "login"; // Hatalı girişte aynı sayfaya dön
        }
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
