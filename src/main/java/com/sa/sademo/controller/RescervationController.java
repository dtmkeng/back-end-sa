package sut.sa.g16.controller;
import sut.sa.g16.entity.Reservation;
import sut.sa.g16.entity.Member;
import sut.sa.g16.repository.ReservationRepository;
import sut.sa.g16.repository.MemberRepository;
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
     private  MemberRepository memberRepository;

    public RescervationController(ReservationRepository reservationRepository, MemberRepository memberRepository) {
        
        this.reservationRepository  = reservationRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/reservation-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Reservation> reservationList() {
        return reservationRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/reservationmember/{memberid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Reservation> reservationUserList(@PathVariable("memberid") Long memberid) {
        Member mem = this.memberRepository.findByMemberId(memberid);
        return reservationRepository.findByMemberId(mem);
    }

    @GetMapping("/reservation-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Reservation reservationFinnd(@PathVariable("id") Long id) {
        return reservationRepository.findByReservationId(id);
    }
    @PostMapping("/mapdata/{reserid}/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public  Reservation checkMap(@PathVariable("reserid") long reserid,@PathVariable("name") String name){
        Member memberid = this.memberRepository.findByName(name);
        return reservationRepository.findByReservationIdAndMemberId(reserid,memberid);
    }


}