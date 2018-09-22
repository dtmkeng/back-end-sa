package com.sa.sademo.repository;
import com.sa.sademo.entity.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PhotographerRepository extends JpaRepository<Photographer, String> {
        Photographer findByPhotograpId(String photograpId);
}