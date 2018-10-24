package sut.sa.g16.repository;
import sut.sa.g16.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface MembersRepository extends JpaRepository<Members, Long> {
    Members findByMemberId(Long memberId);
    Members findByName(String name);   
    Members findByUsernameAndPassword(String username,String password);
}