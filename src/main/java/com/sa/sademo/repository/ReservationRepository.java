package com.sa.sademo.repository;
import com.sa.sademo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}