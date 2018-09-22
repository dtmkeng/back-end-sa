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
    private final PhotographerRepository photographerRepository;
    private final StudioRepository studioRepository;
    private final TypeReserRepository typeReserRepository;

    @Autowired
    public StudioDataloader(TypeReserRepository typeReserRepository, StudioRepository studioRepository, PhotographerRepository photographerRepository, MemberRepository memberRepository,ReservationRepository reservationRepository,CancelReserRepository cancelReserRepository ) {
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
        this.cancelReserRepository = cancelReserRepository;
        this.photographerRepository = photographerRepository;
        this.studioRepository = studioRepository;
        this.typeReserRepository = typeReserRepository;
    }
    
	@Override
    // @Bean
	public void run(ApplicationArguments args) throws Exception {
        

        this.memberRepository.save(new Member("M0001","mem1","1234","john0","test0@test.com","081-13549"));
        this.memberRepository.save(new Member("M0002","mem2","1234","john1","test1@test.com","071-13549"));
        this.memberRepository.save(new Member("M0003","mem3","1234","john2","test2@test.com","061-13549"));
        this.memberRepository.save(new Member("M0004","mem4","1234","john3","test3@test.com","091-13549"));
        
        this.typeReserRepository.save(new TypeReser("T01","Photographer"));
        this.typeReserRepository.save(new TypeReser("T10","Studio"));
        this.typeReserRepository.save(new TypeReser("T11","Photographer&Studio"));

        this.photographerRepository.save(new Photographer("PH001","โอ๊ต–ชัยสิทธิ์ จุนเจือดี","ช่างภาพงานแต่งงาน","081-201-2354"));
        this.studioRepository.save(new Studio("ST0001","THE GRAND CARPE DIEM STUDIO","สวนภายนอกและงานอินทีเรียร์คาแร็คเตอร์โดดเด่น รับแสงธรรมชาติจากสวนภายนอกเข้า","08-4110-9865"));

        
        // Reservation reser1 = new Reservation("R001","R",1226.00,"จองช่างภาพ","M0001","PH001","ST0001");

         this.reservationRepository.save(new Reservation("R001","R",1226.00,"จองช่างภาพ","M0001","PH001","ST0001"));
         this.reservationRepository.save(new Reservation("R002","R",1000.00,"จองช่างภาพเเละสตูดิโอถ่ายภาพ","M0002","PH001","ST0001"));
         this.reservationRepository.save(new Reservation("R003","R",1234.00,"จองช่างภาพ เต็มวัน","M0003","PH001","ST0001"));

        //  //test controller
        //  Photographer ph1 = this.photographerRepository.findByPhotograpId("PH001");
        //  Studio std1 = this.studioRepository.findByStudioId("ST0001");
        //  Reservation re1 = this.reservationRepository.findByReserId("R001");
        //  String typeId;

        //  if(ph1 != null && std1 == null)
        //         typeId = "T01";
        //  else if (ph1 == null && std1 != null)
        //         typeId = "T10";
        //  else   
        //         typeId = "T11";
        // TypeReser typefind = this.typeReserRepository.findByTypeId(typeId);
        //         //save cancel data
        //         // System.out.println(re1);
        //         CancelReser cancel1 = new CancelReser("C001","I your farther","งานบวชจ้า",re1,ph1,std1,typefind);
        //         this.cancelReserRepository.save(cancel1);
        //          System.out.println(cancel1);
        
	}

}