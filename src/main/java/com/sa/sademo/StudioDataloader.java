package sut.sa.g16;
import sut.sa.g16.repository.*;
import sut.sa.g16.entity.*;
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
    private final MembersRepository membersRepository;
    private final ReservationRepository reservationRepository;
    private final PhotographerRepository photographerRepository;
    private final StudioRepository studioRepository;
    private final TypeReservationRepository typeReservationRepository;
    private final TimetypeRepository timetypeRepository;
    private final AdminRepository adminRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public StudioDataloader(CategoryRepository categoryRepository,AdminRepository adminRepository,TimetypeRepository timetypeRepository,TypeReservationRepository typeReservationRepository, StudioRepository studioRepository, PhotographerRepository photographerRepository, MembersRepository membersRepository,ReservationRepository reservationRepository) {
        this.membersRepository = membersRepository;
        this.timetypeRepository = timetypeRepository;
        this.reservationRepository = reservationRepository;
        this.photographerRepository = photographerRepository;
        this.studioRepository = studioRepository;
        this.typeReservationRepository = typeReservationRepository;
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
    }
    
	@Override
    // @Bean
	public void run(ApplicationArguments args) throws Exception {
        
       Admin a =  this.adminRepository.save(new Admin("เจ้าของ","00"));
        this.adminRepository.save(new Admin("admin","000"));
       Category c =  this.categoryRepository.save(new Category("งานแต่ง"));
         this.categoryRepository.save(new Category("งานรับปริญญา"));
         this.categoryRepository.save(new Category("อีเว้น"));
         this.categoryRepository.save(new Category("งานบวช"));
       Members m1 = this.membersRepository.save(new Members("mem1","1234","john0","test0@test.com","081-13549"));
       Members m2 =  this.membersRepository.save(new Members("mem2","1234","john1","test1@test.com","071-13549"));
       Members m3 = this.membersRepository.save(new Members("mem3","1234","john2","test2@test.com","061-13549"));
       Members m4 = this.membersRepository.save(new Members("mem4","1234","john3","test3@test.com","091-13549"));
        
        this.typeReservationRepository.save(new TypeReservation("T01","Photographer"));
        this.typeReservationRepository.save(new TypeReservation("T10","Studio"));
        this.typeReservationRepository.save(new TypeReservation("T11","Photographer&Studio"));

       Photographer p =  this.photographerRepository.save(new Photographer("โอ๊ต–ชัยสิทธิ์ จุนเจือดี","ช่างภาพงานแต่งงาน","081-201-2354",1000.9)); // fix
       Studio t = this.studioRepository.save(new Studio("THE GRAND CARPE DIEM STUDIO","สวนภายนอกและงานอินทีเรียร์คาแร็คเตอร์โดดเด่น รับแสงธรรมชาติจากสวนภายนอกเข้า","08-4110-9865",5000.00));

        
        Timetype t1 = this.timetypeRepository.save(new Timetype ("เต็มวัน"));
        Timetype t2 = this.timetypeRepository.save(new Timetype ("ครึ่งวัน"));
      
            this.reservationRepository.save(new Reservation(500.00,m1,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(1226.00,m1,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(1000.00,m1,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(1226.00,m2,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(226.00,m2,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(1226.00,m2,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(300.00,m3,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(6000.00,m3,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(5000.00,m3,p,t,t1,new Date()));
            this.reservationRepository.save(new Reservation(1226.00,m3,p,t,t1,new Date()));
        //   this.reservationRepository.save(new Reservation(1226.00,m1,1L,1L,t2,new Date()));
        //  this.reservationRepository.save(new Reservation(1000.00,m2,1L,1L,t2,new Date()));
        //  this.reservationRepository.save(new Reservation(1234.00,m3,1L,1L,t1, new Date()));

	}

}