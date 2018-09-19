package com.sa.sademo;
import com.sa.sademo.repository.*;
import com.sa.sademo.entity.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
@Component
public class StudioDataloader implements ApplicationRunner {
    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;
    private final CancelReserRepository cancelReserRepository;

    @Autowired
    public StudioDataloader(MemberRepository memberRepository,ReservationRepository reservationRepository,CancelReserRepository cancelReserRepository ) {
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
        this.cancelReserRepository = cancelReserRepository;
    }
    
	@Override
    // @Bean
	public void run(ApplicationArguments args) throws Exception {
        

        this.memberRepository.save(new Member("M0001","mem1","john0","test0@test.com","081-13549"));
        // this.memberRepository.save(new Member("M0002","mem2","john1","test1@test.com","071-13549"));
        // this.memberRepository.save(new Member("M0003","mem3","john2","test2@test.com","061-13549"));
        // this.memberRepository.save(new Member("M0004","mem4","john3","test3@test.com","091-13549"));
        //   CancelReser c = new CancelReser("m1","ok","I your fatter");
        // this.cancelReserRepository.save(c);
         CancelReser cancelId =  this.cancelReserRepository.findByCancelId("c1");
         Reservation r = new Reservation("R001","R",1226.00,"จองช่างภาพ",null,"M0001");
         this.reservationRepository.save(r);
        // this.reservationRepository.save(new Reservation());
	}

}