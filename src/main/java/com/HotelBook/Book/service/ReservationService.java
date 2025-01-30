package com.HotelBook.Book.service;

import com.HotelBook.Book.DTO.CustomerReservationDTO;
import com.HotelBook.Book.entity.Reservations;
import com.HotelBook.Book.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservations addReservation (Reservations reservations) {
        return reservationRepository.save(reservations);
    }

    public Reservations updateReservation (Long ID , CustomerReservationDTO customerReservationDTO) {
        Optional<Reservations> reservationsOptional = reservationRepository.findById(ID);
        System.out.println(reservationsOptional.isPresent());
        if (reservationsOptional.isPresent()) {
                reservationsOptional.get().setDurum(customerReservationDTO.getDurum());
                reservationsOptional.get().setOdemeDurumu(customerReservationDTO.getOdemeDurumu());
                return reservationRepository.save(reservationsOptional.get());
        } else {
            throw new RuntimeException("User not found");
        }

    }

}
