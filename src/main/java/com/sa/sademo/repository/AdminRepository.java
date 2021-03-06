package sut.sa.g16.repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g16.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g16.entity.Admin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Admin, Long>{
    Admin findByAdminid(Long adminid);
    Admin findByUsernameAndPassword(String username,String password);
}





