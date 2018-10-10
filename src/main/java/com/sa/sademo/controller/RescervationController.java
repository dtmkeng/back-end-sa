package sut.sa.g16.controller;
import sut.sa.g16.entity.Reservation;
import sut.sa.g16.repository.ReservationRepository;
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
    public Reservation reservationFinnd(@PathVariable("id") Long id) {
        return reservationRepository.findByReserId(id);
    }
}