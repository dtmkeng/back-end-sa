package com.sa.sademo.controller;
import com.sa.sademo.entity.CancelReser;
import com.sa.sademo.repository.CancelReserRepository;
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

    public CancelController( CancelReserRepository cancelReserRepository) {
        this.cancelReserRepository  = cancelReserRepository;
    }
    @GetMapping("/cancel-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CancelReser cancelList(@PathVariable("id") String id) {
        return cancelReserRepository.findByCancelId(id);
    }

   
}