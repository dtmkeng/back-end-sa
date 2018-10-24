package sut.sa.g16.repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g16.entity.Workschudule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface WorkschuduleRepository extends JpaRepository<Workschudule, Long>{
    Workschudule findByWorkschuduleid(Long workschuduleid);
}
