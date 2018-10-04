package sut.sa.g16.repository;
import sut.sa.g16.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByMemberId(String memberId);   
    Member findByUsernameAndPassword(String username,String password);
}