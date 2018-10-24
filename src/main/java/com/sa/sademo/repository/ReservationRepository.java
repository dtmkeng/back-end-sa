package sut.sa.g16.repository;
import sut.sa.g16.entity.Reservation;
import sut.sa.g16.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Collection;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByReservationId(Long reservationId);
    Collection<Reservation> findByMemberId(Members memberId);
    Reservation findByReservationIdAndMemberId(Long  reservationId, Members memberId);

}