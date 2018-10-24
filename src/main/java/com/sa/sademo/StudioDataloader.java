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

import java.util.stream.Stream;
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
    private final TypeRepos typeRepos;
    private final BookingRepository bookingRepository;
    private final BrandEquipmentRepository brandEquipmentRepository;
    private final EquipmentRepository equipmentRepository;
    private final TypeEquimentRepository typeEquimentRepository;
    private final SendPhotoRepository sendPhotoRepository;
    private final TypeDeliveryRepository typeDeliveryRepository;
    private final TypePhotoRepository typePhotoRepository;
    private final TypeSizeRepository typeSizeRepository;

    @Autowired
    public StudioDataloader(EquipmentRepository equipmentRepository,BrandEquipmentRepository brandEquipmentRepository,BookingRepository bookingRepository,TypeRepos typeRepos,CategoryRepository categoryRepository,
    AdminRepository adminRepository,TimetypeRepository timetypeRepository,TypeReservationRepository typeReservationRepository, 
    StudioRepository studioRepository, PhotographerRepository photographerRepository, MembersRepository membersRepository,
    ReservationRepository reservationRepository,TypeEquimentRepository typeEquimentRepository,SendPhotoRepository sendPhotoRepository
    ,TypeDeliveryRepository typeDeliveryRepository
    ,TypePhotoRepository typePhotoRepository,TypeSizeRepository typeSizeRepository) {
        this.membersRepository = membersRepository;
        this.timetypeRepository = timetypeRepository;
        this.reservationRepository = reservationRepository;
        this.photographerRepository = photographerRepository;
        this.studioRepository = studioRepository;
        this.typeReservationRepository = typeReservationRepository;
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
        this.typeRepos = typeRepos;
        this.bookingRepository = bookingRepository;
        this.brandEquipmentRepository = brandEquipmentRepository;
        this.equipmentRepository = equipmentRepository;
        this.typeEquimentRepository = typeEquimentRepository;
        this.sendPhotoRepository=sendPhotoRepository;
        this.typeDeliveryRepository=typeDeliveryRepository;
        this.typePhotoRepository=typePhotoRepository;
        this.typeSizeRepository=typeSizeRepository;
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
       Member m1 = this.membersRepository.save(new Member("mem1","1234","john0","test0@test.com","081-13549"));
       Member m2 =  this.membersRepository.save(new Member("mem2","1234","john1","test1@test.com","071-13549"));
       Member m3 = this.membersRepository.save(new Member("mem3","1234","john2","test2@test.com","061-13549"));
       Member m4 = this.membersRepository.save(new Member("mem4","1234","john3","test3@test.com","091-13549"));
        
        this.typeReservationRepository.save(new TypeReservation("T01","Photographer"));
        this.typeReservationRepository.save(new TypeReservation("T10","Studio"));
        this.typeReservationRepository.save(new TypeReservation("T11","Photographer&Studio"));

       Photographer p =  this.photographerRepository.save(new Photographer("โอ๊ต–ชัยสิทธิ์ จุนเจือดี","ช่างภาพงานแต่งงาน","081-201-2354",1000.9)); // fix
       Studio t = this.studioRepository.save(new Studio("THE GRAND CARPE DIEM STUDIO","สวนภายนอกและงานอินทีเรียร์คาแร็คเตอร์โดดเด่น รับแสงธรรมชาติจากสวนภายนอกเข้า","08-4110-9865",5000.00));

        
        Timetype t1 = this.timetypeRepository.save(new Timetype ("เต็มวัน"));
        Timetype t2 = this.timetypeRepository.save(new Timetype ("ครึ่งวัน"));
      
      //demo ===================================================================================================
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

         this.bookingRepository.save(new BookingEquipment("WAWOW","camera"," canon",200,
               2,new Date(),new Date()));
        // ==================================================================================================
        this.typeRepos.save(new Type("BookingEquipment"));
        this.typeRepos.save(new Type("Reservation"));

        this.typeDeliveryRepository.save(new TypeDelivery("Kerry"));
        this.typeDeliveryRepository.save(new TypeDelivery("Post"));
        this.typeDeliveryRepository.save(new TypeDelivery("Self"));
        

        this.typePhotoRepository.save(new TypePhoto("Aulbum"));
        this.typePhotoRepository.save(new TypePhoto("Single"));
        this.typePhotoRepository.save(new TypePhoto("BigSize"));


        this.typeSizeRepository.save(new TypeSize("A4"));
        this.typeSizeRepository.save(new TypeSize("A3"));
        this.typeSizeRepository.save(new TypeSize("4*6 in"));
        this.typeSizeRepository.save(new TypeSize("FullSize"));
       

         
         Stream.of("Canon","Nikon","Sony","Other").forEach(brand ->{
                if(brand.equals("Canon")){
                    BrandEquipment brandEquipment = new BrandEquipment();
                    brandEquipment.setEquipmentBrand("Canon");
                    brandEquipmentRepository.save(brandEquipment);

                }
                if(brand.equals("Nikon")){
                    BrandEquipment brandEquipment = new BrandEquipment();
                    brandEquipment.setEquipmentBrand("Nikon");
                    brandEquipmentRepository.save(brandEquipment);

                }
                if(brand.equals("Sony")){
                    BrandEquipment brandEquipment = new BrandEquipment();
                    brandEquipment.setEquipmentBrand("Sony");
                    brandEquipmentRepository.save(brandEquipment);

                }
                if(brand.equals("Other")){
                    BrandEquipment brandEquipment = new BrandEquipment();
                    brandEquipment.setEquipmentBrand("Other");
                    brandEquipmentRepository.save(brandEquipment);

                }
            });
            Stream.of("Camera","Lens","Tripod && Accessories","StudioLight").forEach(type ->{
                if(type.equals("Camera")){
                    TypeEquipment typeEquipment = new TypeEquipment();
                    typeEquipment.setEquipmentType("Camera");
                    typeEquimentRepository.save(typeEquipment);
                }
                if(type.equals("Lens")){
                    TypeEquipment typeEquipment = new TypeEquipment();
                    typeEquipment.setEquipmentType("Lens");
                    typeEquimentRepository.save(typeEquipment);
                }
                if(type.equals("Tripod && Accessories")){
                    TypeEquipment typeEquipment = new TypeEquipment();
                    typeEquipment.setEquipmentType("Tripod && Accessories");
                    typeEquimentRepository.save(typeEquipment);
                }
                if(type.equals("StudioLight")){
                    TypeEquipment typeEquipment = new TypeEquipment();
                    typeEquipment.setEquipmentType("StudioLight");
                    typeEquimentRepository.save(typeEquipment);
                }
            });
            Stream.of("Canon EOS 5D Mark IV Body", "Sony A7RIII Body", "Nikon D850 Body", "Fujifilm X-H1 Body",
                    "Olympus OM-D E-M1 Mark II Body", "Canon EF 11-24mm f4L USM", "Canon EF 70-200mm f2.8L IS III USM",
                    "Canon TS-E 17mm f4L Tilt-Shift","Nikon AF-S 14-24mm f2.8G ED Nano","Nikon AF-S 70-200mm f2.8E FL ED VR Nano",
                    "Sony FE 50mm f1.4 Planar T* ZA", "Sony FE 100-400mm f4.5-5.6 GM OSS","ไม้กันสั่น Zhiyun Crane 2 Gimbal Stabilizer",
                    "Sandisk SD Card Extreme PRO 128GB 95MB/s", "แบตเตอรี่ Canon LP-E6", "Reflector 5 in 1 ขนาด 105cm (ทรงกลม)",
                    "Canon 600EX II-RT", "GoPro HERO7 Black", "Sony HVL-F60RM" ,"Nikon SB-5000", "Rode VideoMic Pro Plus On-Camera Shotgun Microphone").forEach(equipmentName ->{
                if(equipmentName.equals("Canon EOS 5D Mark IV Body")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Canon EOS 5D Mark IV Body");
                    equipment.setEquipmentPrice(1500);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(1L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(1L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Nikon D850 Body")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Nikon D850 Body");
                    equipment.setEquipmentPrice(1600);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(1L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(2L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Sony A7RIII Body")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Sony A7RIII Body");
                    equipment.setEquipmentPrice(1700);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(1L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(3L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Fujifilm X-H1 Body")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Fujifilm X-H1 Body");
                    equipment.setEquipmentPrice(1000);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(1L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(4L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Olympus OM-D E-M1 Mark II Body")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Olympus OM-D E-M1 Mark II Body");
                    equipment.setEquipmentPrice(700);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(1L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(4L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Canon EF 11-24mm f4L USM")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Canon EF 11-24mm f4L USM");
                    equipment.setEquipmentPrice(1000);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(2L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(1L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Canon EF 70-200mm f2.8L IS III USM")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Canon EF 70-200mm f2.8L IS III USM");
                    equipment.setEquipmentPrice(800);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(2L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(1L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Canon TS-E 17mm f4L Tilt-Shift")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Canon TS-E 17mm f4L Tilt-Shift");
                    equipment.setEquipmentPrice(1000);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(2L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(1L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Nikon AF-S 14-24mm f2.8G ED Nano")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Nikon AF-S 14-24mm f2.8G ED Nano");
                    equipment.setEquipmentPrice(600);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(2L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(2L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Nikon AF-S 70-200mm f2.8E FL ED VR Nano")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Nikon AF-S 70-200mm f2.8E FL ED VR Nano");
                    equipment.setEquipmentPrice(800);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(2L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(2L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Sony FE 50mm f1.4 Planar T* ZA")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Sony FE 50mm f1.4 Planar T* ZA");
                    equipment.setEquipmentPrice(700);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(2L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(3L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Sony FE 100-400mm f4.5-5.6 GM OSS")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Sony FE 100-400mm f4.5-5.6 GM OSS");
                    equipment.setEquipmentPrice(900);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(2L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(3L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("ไม้กันสั่น Zhiyun Crane 2 Gimbal Stabilizer")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("ไม้กันสั่น Zhiyun Crane 2 Gimbal Stabilizer");
                    equipment.setEquipmentPrice(1000);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(3L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(4L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Sandisk SD Card Extreme PRO 128GB 95MB/s")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Sandisk SD Card Extreme PRO 128GB 95MB/s");
                    equipment.setEquipmentPrice(150);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(3L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(4L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("แบตเตอรี่ Canon LP-E6")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("แบตเตอรี่ Canon LP-E6");
                    equipment.setEquipmentPrice(50);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(3L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(1L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Reflector 5 in 1 ขนาด 105cm (ทรงกลม)")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Reflector 5 in 1 ขนาด 105cm (ทรงกลม)");
                    equipment.setEquipmentPrice(50);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(3L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(4L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Rode VideoMic Pro Plus On-Camera Shotgun Microphone")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Rode VideoMic Pro Plus On-Camera Shotgun Microphone");
                    equipment.setEquipmentPrice(400);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(3L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(4L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Canon 600EX II-RT")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Canon 600EX II-RT");
                    equipment.setEquipmentPrice(50);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(4L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(1L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("GoPro HERO7 Black")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("GoPro HERO7 Black");
                    equipment.setEquipmentPrice(400);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(1L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(4L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Sony HVL-F60RM")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Sony HVL-F60RM");
                    equipment.setEquipmentPrice(350);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(4L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(3L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }

                if(equipmentName.equals("Nikon SB-5000")){
                    Equipment equipment = new Equipment();
                    equipment.setEquipmentName("Nikon SB-5000");
                    equipment.setEquipmentPrice(250);
                    TypeEquipment typeEquipment = typeEquimentRepository.findBytypeEquId(4L);
                    equipment.setTypeEquipment(typeEquipment);
                    BrandEquipment brandEquipment = brandEquipmentRepository.findBybrandEquId(2L);
                    equipment.setBrandEquipment(brandEquipment);
                    equipmentRepository.save(equipment);
                }
            });
	}

}