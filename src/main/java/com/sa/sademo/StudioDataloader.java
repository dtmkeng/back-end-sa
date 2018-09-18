package com.sa.sademo;
import com.sa.sademo.repository.*;
import com.sa.sademo.entity.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudioDataloader implements ApplicationRunner {
    private final MemberRepository memberRepository;

    @Autowired
    public StudioDataloader(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
	@Override
	public void run(ApplicationArguments args) throws Exception {
        this.memberRepository.save(new Member("mem1","john0","test0@test.com","081-13549"));
        this.memberRepository.save(new Member("mem2","john1","test1@test.com","071-13549"));
        this.memberRepository.save(new Member("mem3","john2","test2@test.com","061-13549"));
        this.memberRepository.save(new Member("mem4","john3","test3@test.com","091-13549"));
	}

}