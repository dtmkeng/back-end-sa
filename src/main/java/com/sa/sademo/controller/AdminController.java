package sut.sa.g16.cotroller;
import org.springframework.beans.factory.annotation.Autowired;
import sut.sa.g16.entity.Admin;
import sut.sa.g16.repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.*;
@RestController
public class AdminController {
    private AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @GetMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Admin> admin() {
        return adminRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/admin-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Admin Findadmin(@PathVariable("id") Long id) {
        return adminRepository.findByAdminid(id);
    }
    @PostMapping("/admin-list/{username}/pass/{pass}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Object>>   adminCheck(@PathVariable("username") String username,@PathVariable("pass") String pass) {
        Admin admin  = this.adminRepository.findByUsernameAndPassword(username,pass);
        if(admin != null){
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", true);
            json.put("status", "found");
            json.put("admin", admin);


            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        }else{
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", false);
            json.put("status", "not found");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "404");
            return  (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        }
    }
}

