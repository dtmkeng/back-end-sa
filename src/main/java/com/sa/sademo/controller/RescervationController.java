package com.sa.sademo.controller;
import com.sa.sademo.entity.Reservation;
import com.sa.sademo.repository.ReservationRepository;
//time


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;


@RestController
class RescervationController {
    private  ReservationRepository reservationRepository;

    public RescervationController(ReservationRepository reservationRepository) {
        this.reservationRepository  = reservationRepository;
    }

    @GetMapping("/reservation-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Reservation> reservationList() {
        return reservationRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/reservation-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Reservation reservationFinnd(@PathVariable("id") String id) {
        return reservationRepository.findByReserId(id);
    }
}