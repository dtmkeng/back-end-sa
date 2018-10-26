package sut.sa.g16.controller;
import  sut.sa.g16.model.*;
import  sut.sa.g16.repository.*;
import  sut.sa.g16.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReserController {
    private final MembersRepository membersRepository;
    private final ReservationRepository reservationRepository;
    private final PhotographerRepository photographerRepository;
    private final StudioRepository studioRepository;
    private final TimetypeRepository timetypeRepository;

    @Autowired
    public ReserController( MembersRepository membersRepository,ReservationRepository reservationRepository,PhotographerRepository photographerRepository,StudioRepository studioRepository,TimetypeRepository timetypeRepository) {
        this.membersRepository = membersRepository;
        this.reservationRepository = reservationRepository;
        this.photographerRepository = photographerRepository;
        this.studioRepository = studioRepository;
        this.timetypeRepository = timetypeRepository;
    }
    @GetMapping(path = "/studio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Studio> studio() {
        return studioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Member> members() {
        return membersRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Reservation> reservation() {
        return reservationRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/reservationid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  Reservation reservationUserList(@PathVariable("id") Long id) {
        return reservationRepository.findByReservationId(id);
    }
    @GetMapping(path = "/timetype", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Timetype> timetype() {
        return timetypeRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path = "/data")
    public Reservation bodyUser(@RequestBody ReservationData reservationData){
       // Double price, Members members,Photographer photographer,Studio studio,Timetype timetype, Date date
        Photographer p = (reservationData.getIdphotographer()!=null) ? this.photographerRepository.findByPhotograpId(reservationData.getIdphotographer()) : null;
        Studio s = (reservationData.getIdstudio()!=null) ? this.studioRepository.findByStudioId(reservationData.getIdstudio()) : null;
        Double price = ((s!=null) ? s.getPrice() : 0.0) + ((p!=null)? p.getPrice() : 0.0);
        Member m = this.membersRepository.findByMemberId(reservationData.getMemberid());
        Timetype t = this.timetypeRepository.findByTimetypeid(reservationData.getTypetimeid());


        Reservation r=this.reservationRepository.save(new Reservation(price,m,p,s,t,reservationData.getDate()));

        return r;
    }
    
}