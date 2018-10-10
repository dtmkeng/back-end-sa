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
@NotNull
@SequenceGenerator(name="reserId_seq",sequenceName="reserId_seq")               
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reserId_seq")     
private Long reserId;

@NotNull
private Long photographerId;

@NotNull
private Long studioId;

@NotNull
private Date  dateCancel;

@NotNull
private String detail;

@NotNull 
private Long memberId;

@NotNull
private String  status;
@NotNull
private Double price; 



@OneToOne(fetch = FetchType.LAZY)
private CancelReservation cancelReservation;

private Reservation() {}

public Reservation(String  status, Double price, String detail,Long memberId,Long photographerId,Long studioId) { 
        this.reserId = reserId;
        this.status = status;
        this.price = price;
        this.dateCancel = new Date();
        this.detail = detail;
       
        this.memberId = memberId;
        this.studioId = studioId;
        this.photographerId = photographerId;

     
    }
}