package com.sa.sademo.repository;
import com.sa.sademo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByMemberId(String memberId);   
    Member findByUsernameAndPassword(String username,String password);
}