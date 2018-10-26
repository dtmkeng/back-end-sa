package sut.sa.g16.repository;

import sut.sa.g16.entity.SendPhoto;
import sut.sa.g16.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Collection;
@RepositoryRestResource

public interface SendPhotoRepository extends JpaRepository<SendPhoto,String> {
        Collection<SendPhoto> findByMember(Member member);
}
