package sut.sa.g16.repository;

import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g16.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Collection;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface BookingRepository extends JpaRepository<BookingEquipment, Long>{
    BookingEquipment findByequipmentName(String equipmentName);
    BookingEquipment findByBookingId(Long bookingId);
    Collection<BookingEquipment> findByMember(Member member);
}
