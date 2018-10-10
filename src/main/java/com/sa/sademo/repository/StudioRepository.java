package sut.sa.g16.repository;
import sut.sa.g16.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface StudioRepository extends JpaRepository<Studio, Long> {
    Studio findByStudioId(Long studioId);
}