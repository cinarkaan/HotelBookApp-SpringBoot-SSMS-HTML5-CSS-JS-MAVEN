package com.HotelBook.Book.controller;


import com.HotelBook.Book.entity.User;
import com.HotelBook.Book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{ID}")
    public ResponseEntity<User> update (@PathVariable String ID, @RequestBody User user) {
        /*
        System.out.println("Received User ID: " + ID);
        System.out.println("Received User UserId: " + user.getKullaniciAdi());
        System.out.println("Received User NameSurname: " + user.getAdSoyad());
        System.out.println("Received User Email: " + user.getEmail());
        System.out.println("Received User Password: " + user.getSifre());
        System.out.println("Received User Phone: " + user.getTelefon());
         */
        userService.updateUser(Long.valueOf(ID), user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{ID}")
    public void deleteUser (@PathVariable String ID) {
        //System.out.println("USER ID : " + String.valueOf(ID));
        userService.deleteUser(Long.valueOf(ID));
    }


}
