package sut.sa.g16.controller;
        import sut.sa.g16.entity.*;
        import sut.sa.g16.repository.*;
        import sut.sa.g16.model.*;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.MediaType;

        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.*;
        import java.util.Collection;
        import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SendController {
    private final MembersRepository membersRepository;
    private final ReservationRepository reservationRepository;
    private final SendPhotoRepository sendPhotoRepository;
    private final TypeDeliveryRepository typeDeliveryRepository;
    private final TypePhotoRepository typePhotoRepository;
    private final TypeSizeRepository typeSizeRepository;

    @Autowired
    public SendController(MembersRepository membersRepository,ReservationRepository reservationRepository,SendPhotoRepository sendPhotoRepository
    ,TypeDeliveryRepository typeDeliveryRepository,TypePhotoRepository typePhotoRepository,TypeSizeRepository typeSizeRepository) {
        this.membersRepository=membersRepository;
        this.reservationRepository=reservationRepository;
        this.sendPhotoRepository=sendPhotoRepository;
        this.typeDeliveryRepository=typeDeliveryRepository;
        this.typePhotoRepository=typePhotoRepository;
        this.typeSizeRepository=typeSizeRepository;
    }

//-------------------------------------------------------------------
    @GetMapping(path = "/typeDelivery", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypeDelivery> typeDelivery() {
        return typeDeliveryRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/typeDelivery-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TypeDelivery typeDeliveryIdFind(@PathVariable("id") Long id) {
        return typeDeliveryRepository.findByTypeDaliveryId(id);
    }

//-----------------------------------------------------------------------
    @GetMapping(path = "/typePhoto", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypePhoto> typePhotos() {
        return typePhotoRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/typePhoto-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TypePhoto typePhotoIdFind(@PathVariable("id") Long id) {
        return typePhotoRepository.findByTypePhotoId(id);
    }

    //----------------------------------------------------------
    @GetMapping(path = "/typeSize", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypeSize> typeSizes() {
        return typeSizeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/typeSize-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TypeSize typeSizeIdFind(@PathVariable("id") Long id) {
        return typeSizeRepository.findByTypeSizeId(id);
    }

     
    //String sendId, String name, String email, String address
   
    @PostMapping(path = "/datasend")
    public SendPhoto name(@RequestBody DataSendPhoto dataSendPhoto){

        Members m = this.membersRepository.findByMemberId(dataSendPhoto.getMemberId());
        Reservation r = this.reservationRepository.findByReservationId(dataSendPhoto.getReservationId());

        TypeDelivery td = this.typeDeliveryRepository.findByTypeDaliveryId(dataSendPhoto.getTypeDeliveryId());
        TypePhoto tp = this.typePhotoRepository.findByTypePhotoId(dataSendPhoto.getTypePhotoId());
        TypeSize ts = this.typeSizeRepository.findByTypeSizeId(dataSendPhoto.getTypeSizeId());
        System.out.println(dataSendPhoto);
        // public SendPhoto(Member member, Reservation reservationId, TypeDelivery typeDeliveryId, TypePhoto typePhotoId, TypeSize typeSizeId,String name,
        // String email,String address){
       SendPhoto sp = this.sendPhotoRepository.save(new SendPhoto(m,r,td,tp,ts, dataSendPhoto.getName(), dataSendPhoto.getEmail(), dataSendPhoto.getAddress()));
        return sp;
    }
    
}