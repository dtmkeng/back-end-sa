package com.sa.sademo.repository;
import com.sa.sademo.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
public interface StudioRepository extends JpaRepository<Studio, String> {
    Studio findByStudioId(String studioId);
}