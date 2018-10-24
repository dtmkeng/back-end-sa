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
public class TypeSizeController{
    private TypeSizeRepository repository;
    public TypeSizeController(TypeSizeRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/TypeSizeController")
    public Collection<TypeSize> typeSizes() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}