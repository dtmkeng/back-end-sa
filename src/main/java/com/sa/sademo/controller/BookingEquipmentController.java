package sut.sa.g16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import sut.sa.g16.entity.*;
import sut.sa.g16.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class BookingEquipmentController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BrandEquipmentRepository brandEquipmentRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private MembersRepository membersRepository;
    @Autowired
    private TypeEquimentRepository typeEquimentRepository;
    @Autowired
    public BookingEquipmentController(BookingRepository bookingRepository, BrandEquipmentRepository brandEquipmentRepository, EquipmentRepository equipmentRepository,
                                      MembersRepository membersRepository, TypeEquimentRepository typeEquimentRepository) {
        this.bookingRepository = bookingRepository;
        this.brandEquipmentRepository = brandEquipmentRepository;
        this.equipmentRepository = equipmentRepository;
        this.membersRepository = membersRepository;
        this.typeEquimentRepository = typeEquimentRepository;
    }

    @GetMapping(path = "/booking", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<BookingEquipment> BookingEquipment() {
        return bookingRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/brand", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<BrandEquipment> BrandEquipment() {
        return brandEquipmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Equipment> equipment() {
        return equipmentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Equipment> equipmentNull() {
        return equipmentRepository.findAllNull(null).stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Members> member() {
        return membersRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypeEquipment> typeEquipment() {
        return typeEquimentRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/booking/{equipmentNameSelect}/{dateStartInput}/{dateEndInput}/{totalDayInput}/{memberIdInput}")
    public Equipment bookingEquipment(@RequestBody BookingEquipment newBookingEquipment,@PathVariable String equipmentNameSelect, @PathVariable Date dateStartInput,
                                     @PathVariable Date dateEndInput, @PathVariable int totalDayInput, @PathVariable Long memberIdInput){
        BookingEquipment bookingsEquipment = new BookingEquipment();
        Equipment  E = equipmentRepository.findByEquipmentName(equipmentNameSelect);
        BrandEquipment b = E.getBrandEquipment();
        TypeEquipment t = E.getTypeEquipment();
        bookingsEquipment.setEquipmentName(E.getEquipmentName());
        System.out.println(bookingsEquipment.getEquipmentName());
        bookingsEquipment.setEquipmentType(t.getEquipmentType());
        System.out.println(bookingsEquipment.getEquipmentType());
        bookingsEquipment.setEquipmentBrand(b.getEquipmentBrand());
        System.out.println(bookingsEquipment.getEquipmentBrand());
        bookingsEquipment.setEquipmentPrice(E.getEquipmentPrice());
        System.out.println(bookingsEquipment.getEquipmentPrice());
        bookingsEquipment.setDateStart(dateStartInput);
        System.out.println(bookingsEquipment.getDateStart());
        bookingsEquipment.setDateEnd(dateEndInput);
        System.out.println(bookingsEquipment.getDateEnd());
        bookingsEquipment.setTotalDay(totalDayInput);
        System.out.println(bookingsEquipment.getTotalDay());
        bookingsEquipment.setMember(membersRepository.findByMemberId(memberIdInput));

        bookingRepository.save(bookingsEquipment);

        Equipment equipment = equipmentRepository.findByEquipmentName(equipmentNameSelect);
        equipment.setBookingEquipment(bookingsEquipment);
        return equipmentRepository.save(equipment);

    }


}
