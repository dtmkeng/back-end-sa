package sut.sa.g16.controller;
import sut.sa.g16.entity.Studio;
import sut.sa.g16.repository.StudioRepository;
//time


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.*;

@RestController
class StudioController {
    private  StudioRepository studioRepository;

    public StudioController(StudioRepository studioRepository) {
        this.studioRepository  = studioRepository;
    }

    @GetMapping("/studio-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Studio> studioList() {
        return studioRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/studio-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Studio studioFind(@PathVariable("id") String id) {
        return studioRepository.findByStudioId(id);
    }
}