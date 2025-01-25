package com.HotelBook.Book.service;

import com.HotelBook.Book.entity.User;
import com.HotelBook.Book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired(required = true)
    private UserRepository userRepository;


    public List<User> getAll () {
        return userRepository.findAll();
    }

    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser (Long ID , User user) {
        Optional<User> userOptional = userRepository.findById(ID);
        System.out.println(userOptional.isPresent());
        if (userOptional.isPresent()) {
            userOptional.get().setKullaniciAdi(user.getKullaniciAdi());
            userOptional.get().setSifre(user.getSifre());
            userOptional.get().setAdSoyad(user.getAdSoyad());
            userOptional.get().setEmail(user.getEmail());
            userOptional.get().setTelefon(user.getTelefon());
            return userRepository.save(userOptional.get());
        } else {
            throw new RuntimeException("User not found");
        }

    }

}
