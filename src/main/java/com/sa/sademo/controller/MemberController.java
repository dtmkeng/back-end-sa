package sut.sa.g16.controller;
import sut.sa.g16.entity.Members;
import sut.sa.g16.model.User;
import sut.sa.g16.repository.MembersRepository;
//time
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

@RestController
class MemberController {
    private  MembersRepository membersRepository;

    public MemberController(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }
     //test req body
    @PostMapping("/userbody")
    public User bodyUser(@RequestBody User user){
            return user;
    }
    
    @GetMapping("/member-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Members> membersList() {
        return membersRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    
    @GetMapping("/member-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Members memberFind(@PathVariable("id") Long id) {

        return membersRepository.findByMemberId(id);
    }
    @PostMapping("/member-list/{username}/pass/{pass}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Object>>   memberCheck(@PathVariable("username") String username,@PathVariable("pass") String pass) {
       Members member  = this.membersRepository.findByUsernameAndPassword(username,pass);
       if(member != null){
                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", true);
                json.put("status", "found");
                json.put("member", member);


                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "302");
                return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
       }else{
                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", false);
                json.put("status", "not found");

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "404");
                return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
       }
    }
}