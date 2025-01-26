package com.HotelBook.Book.controller;


import com.HotelBook.Book.entity.Log;
import com.HotelBook.Book.entity.User;
import com.HotelBook.Book.service.LogService;
import com.HotelBook.Book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers () {
        return userService.getAll();
    }

    @Autowired
    private LogService logService;

    @PutMapping("/{ID}")
    public ResponseEntity<User> update (@PathVariable String ID, @RequestBody User user) throws ParseException {
        Log log = new Log(LoginController.userID, "Güncelleme" , ID + " id'li kullanici güncellendi",getDateCurrent());
        userService.updateUser(Long.valueOf(ID), user);
        logService.addLogRecord(log);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{ID}")
    public void deleteUser (@PathVariable String ID) throws ParseException {
        Log log = new Log(LoginController.userID, "Silme" , ID + "id'li kullanici silindi",getDateCurrent());
        userService.deleteUser(Long.valueOf(ID));
        logService.addLogRecord(log);
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
