package sut.sa.g16.controller;
import  sut.sa.g16.entity.CancelReservation;
import  sut.sa.g16.repository.CancelReservationRepository;
import  sut.sa.g16.repository.*;
import  sut.sa.g16.entity.*;
//time
import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import java.lang.NullPointerException;
@RestController
class CancelController {

    private  CancelReservationRepository cancelReservationRepository;
    private  ReservationRepository reservationRepository;
    private  PhotographerRepository photographerRepository;
    private  StudioRepository studioRepository;
    private  TypeReservationRepository typeReservationRepository;
    private  MemberRepository memberRepository;

    public CancelController(MemberRepository memberRepository,TypeReservationRepository typeReservationRepository, CancelReservationRepository cancelReservationRepository,ReservationRepository reservationRepository,PhotographerRepository photographerRepository,StudioRepository studioRepository) {
        this.cancelReservationRepository  = cancelReservationRepository;
        this.reservationRepository = reservationRepository;
        this.photographerRepository =  photographerRepository;
        this.studioRepository = studioRepository;
        this.typeReservationRepository = typeReservationRepository;
        this.memberRepository = memberRepository;
    }
    @GetMapping("/cancel-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CancelReservation cancelList(@PathVariable("id") Long id) {
        return cancelReservationRepository.findByCancelId(id);
    }

    @PostMapping("/mapdata/{reserid}/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public  Reservation checkMap(@PathVariable("reserid") long reserid,@PathVariable("name") String name){
        Member memberid = this.memberRepository.findByName(name);
        return reservationRepository.findByReserIdAndMemberId(reserid,memberid.getMemberId());
    }

    @PostMapping("/cancel-insert/{id}/comment/{commemt}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Object>>    CancelRecerSubmit(@PathVariable("id") Long id,@PathVariable("commemt") String commemt){
          try{
                Reservation re1 =  this.reservationRepository.findByReserId(id); 

                Photographer ph1 = this.photographerRepository.findByPhotograpId(re1.getPhotographerId());
                Studio std1 = this.studioRepository.findByStudioId(re1.getStudioId());


                String typeId;
                if(ph1 != null && std1 == null)
                    typeId = "T01";
                else if (ph1 == null && std1 != null)
                    typeId = "T10";
                else   
                    typeId = "T11";
      
                TypeReservation typefind = this.typeReservationRepository.findByTypereservationId(typeId);

                CancelReservation  cancel1 = new CancelReservation(commemt,re1,ph1,std1,typefind); //hardcode 
                this.cancelReservationRepository.save(cancel1);

                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", true);
                json.put("status", "save");

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "302");
                return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));

        } catch(NullPointerException e){
                Map<String, Object> json = new HashMap<String, Object>();
                System.out.println("Error Save CancelReservation");
                 json.put("success", false);
                 json.put("status", "save-false");

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "500");
                return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.INTERNAL_SERVER_ERROR));
        }

        // return this.cancelReserRepository.save(cancel1);
        
    }

}