package sut.sa.g16.controller;
import sut.sa.g16.entity.SendPhoto;
import sut.sa.g16.repository.SendPhotoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SendPhotoController {
    private SendPhotoRepository repository;
    public SendPhotoController(SendPhotoRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/SendPhoto")
    public Collection<SendPhoto> sendPhoto() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}
