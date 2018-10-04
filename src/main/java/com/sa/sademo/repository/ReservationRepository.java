package sut.sa.g16.repository;
import sut.sa.g16.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    Reservation findByReserId(String reserId);
    Reservation findByReserIdAndMemberId(String  reserId, String memberId);

}