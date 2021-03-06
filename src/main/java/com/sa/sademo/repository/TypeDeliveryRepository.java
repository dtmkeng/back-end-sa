package sut.sa.g16.repository;

import sut.sa.g16.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource

public interface TypeDeliveryRepository extends JpaRepository<TypeDelivery,String> {
    TypeDelivery findByTypeDaliveryId(Long typeDaliveryId);
}
