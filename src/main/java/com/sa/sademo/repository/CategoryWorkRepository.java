package sut.sa.g16.repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g16.entity.CategoryWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface CategoryWorkRepository extends JpaRepository<CategoryWork, Long>{
    CategoryWork findByCatworkid(Long catworkid);
}
