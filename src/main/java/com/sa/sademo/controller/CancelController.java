package com.sa.sademo.controller;
import com.sa.sademo.entity.CancelReser;
import com.sa.sademo.repository.CancelReserRepository;
import com.sa.sademo.repository.*;
import com.sa.sademo.entity.*;
//time


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.*;

@RestController
class CancelController {
    private  CancelReserRepository cancelReserRepository;
    private  ReservationRepository reservationRepository;
    private  PhotographerRepository photographerRepository;
    private  StudioRepository studioRepository;
    private  TypeReserRepository typeReserRepository;

    public CancelController(TypeReserRepository typeReserRepository, CancelReserRepository cancelReserRepository,ReservationRepository reservationRepository,PhotographerRepository photographerRepository,StudioRepository studioRepository) {
        this.cancelReserRepository  = cancelReserRepository;
        this.reservationRepository = reservationRepository;
        this.photographerRepository =  photographerRepository;
        this.studioRepository = studioRepository;
        this.typeReserRepository = typeReserRepository;
    }
    @GetMapping("/cancel-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CancelReser cancelList(@PathVariable("id") String id) {
        return cancelReserRepository.findByCancelId(id);
    }
    @PostMapping("/mapdata/{reserid}/{memid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public  Reservation checkMap(@PathVariable("reserid") String reserid,@PathVariable("memid") String memid){
        return reservationRepository.findByReserIdAndMemberId(reserid,memid);
    }
    @PostMapping("/cancel-insert/{id}/comment/{commemt}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CancelReser  CancelRecerSubmit(@PathVariable("id") String id,@PathVariable("commemt") String commemt){
            Reservation re1 =  this.reservationRepository.findByReserId(id); 

            Photographer ph1 = this.photographerRepository.findByPhotograpId(re1.getPhotograp_id());
            Studio std1 = this.studioRepository.findByStudioId(re1.getStudio_id());

         String typeId;
         if(ph1 != null && std1 == null)  
                typeId = "T01";
         else if (ph1 == null && std1 != null)
                typeId = "T10";
         else   
                typeId = "T11";
        TypeReser typefind = this.typeReserRepository.findByTypeId(typeId);
                CancelReser cancel1 = new CancelReser("C001",commemt,"งานบวชจ้า",re1,ph1,std1,typefind);
                this.cancelReserRepository.save(cancel1);
        return this.cancelReserRepository.save(cancel1);
    }
}