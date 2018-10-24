package sut.sa.g16.repository;

import sut.sa.g16.entity.SendPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface SendPhotoRepository extends JpaRepository<SendPhoto,String> {
}
