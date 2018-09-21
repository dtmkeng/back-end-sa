package com.sa.sademo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;
import java.util.*;
import java.util.Date;
import java.time.LocalDate;

@Entity  
@Data  
@Table(name="Reservation") 
public class Reservation {

@Id  
@NonNull   
private String reserId;

@NotNull
private String photograp_id;

@NotNull
private String studio_id;

@NotNull
private LocalDate  time;

@NotNull
private String detail;

@NotNull 
private String member_id;

@NotNull
private String  status;
@NotNull
private Double price; 



@OneToOne(fetch = FetchType.LAZY)
private CancelReser cancelReser;

private Reservation() {}

public Reservation(String reserId, String  status, Double price, String detail,String member_id,String photograp_id,String studio_id) { 
        this.reserId = reserId;
        this.status = status;
        this.price = price;
        this.time = LocalDate.now();
        this.detail = detail;
       
        this.member_id = member_id;
        this.studio_id = studio_id;
        this.photograp_id = photograp_id;

     
    }
}