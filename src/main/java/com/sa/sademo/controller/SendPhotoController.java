package sut.sa.g16.controller;
import sut.sa.g16.entity.*;
import sut.sa.g16.repository.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SendPhotoController {
    private final SendPhotoRepository repository;
    private final MembersRepository membersRepository;

    @Autowired
    public SendPhotoController(SendPhotoRepository repository, MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
        this.repository = repository;
    }
    @GetMapping("/sendphoto")
    public Collection<SendPhoto> sendPhoto() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/sendphoto/{member}")
    public Collection<SendPhoto> sendPhotoMember(@PathVariable Long member) {
          Member m = this.membersRepository.findByMemberId(member);
          return this.repository.findByMember(m);
         
    }
}
