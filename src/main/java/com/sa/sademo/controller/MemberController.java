package sut.sa.g16.controller;
import sut.sa.g16.entity.Member;
import sut.sa.g16.repository.MemberRepository;
//time
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
class MemberController {
    private  MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/member-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Member> membersList() {
        return memberRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/member-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Member memberFind(@PathVariable("id") String id) {
        return memberRepository.findByMemberId(id);
    }
    @PostMapping("/member-list/{username}/pass/{pass}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Member memberCheck(@PathVariable("username") String username,@PathVariable("pass") String pass) {
        return memberRepository.findByUsernameAndPassword(username,pass);
    }
}