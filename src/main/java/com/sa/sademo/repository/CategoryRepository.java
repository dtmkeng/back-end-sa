package sut.sa.g16.repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g16.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findByCategoryid(Long categoryid);
}
