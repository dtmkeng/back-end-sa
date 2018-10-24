package sut.sa.g16.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g16.entity.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
    Equipment findByEquipmentName (String equipmentName);

    @Query("SELECT t FROM Equipment t WHERE t.bookingEquipment IS NULL")
    Collection<Equipment> findAllNull(@Param("name")Long NULL);
}
