package com.sa.sademo.controller;
import com.sa.sademo.entity.Photographer;
import com.sa.sademo.repository.PhotographerRepository;
//time
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;


@RestController
class PhotographerController {
    private  PhotographerRepository photographerRepository;

    public PhotographerController(PhotographerRepository photographerRepository) {
        this.photographerRepository  = photographerRepository;
    }

    @GetMapping("/photographrer-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Photographer> photographerList() {
        return photographerRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/photographrer-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Photographer findPhotographer(@PathVariable("id") String id) {
        return photographerRepository.findByPhotograpId(id);
    }
}