package sut.sa.g16.entity;

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
private String photographerId;

@NotNull
private String studioId;

@NotNull
private LocalDate  time;

@NotNull
private String detail;

@NotNull 
private String memberId;

@NotNull
private String  status;
@NotNull
private Double price; 



@OneToOne(fetch = FetchType.LAZY)
private CancelReservation cancelReservation;

private Reservation() {}

public Reservation(String reserId, String  status, Double price, String detail,String memberId,String photographerId,String studioId) { 
        this.reserId = reserId;
        this.status = status;
        this.price = price;
        this.time = LocalDate.now();
        this.detail = detail;
       
        this.memberId = memberId;
        this.studioId = studioId;
        this.photographerId = photographerId;

     
    }
}