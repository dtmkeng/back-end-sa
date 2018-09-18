package com.sa.sademo.controller;
import com.sa.sademo.entity.Member;
import com.sa.sademo.repository.MemberRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
class MemberController {
    private  MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/member-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Member> coolCars() {
        return memberRepository.findAll().stream()
                .collect(Collectors.toList());
    }

   
}