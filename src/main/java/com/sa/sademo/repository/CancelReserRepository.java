package com.sa.sademo.repository;

import com.sa.sademo.entity.CancelReser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
public interface CancelReserRepository extends JpaRepository<CancelReser, String> {
   CancelReser findByCancelId(String cancelId);
   
}