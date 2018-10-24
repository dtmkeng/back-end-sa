package sut.sa.g16.controller;
import sut.sa.g16.entity.*;
import sut.sa.g16.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TypePhotoController{
    private TypePhotoRepository repository;
    public TypePhotoController(TypePhotoRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/TypePhotoController")
    public Collection<TypePhoto> typePhotos() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}