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
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.text.SimpleDateFormat;
// import java.text.ParseException;
@Entity  
@Data  
@Table(name="Reservation") 
public class Reservation {

@Id  
@NonNull   
private String reser_id;

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
@JoinColumn(name = "cancelReser_id",nullable = true)
private CancelReser cancelReser;

private Reservation() {}

public Reservation(String reser_id, String  status, Double price, String detail,CancelReser cancelReser,String member_id) { 
        this.reser_id = reser_id;
        this.status = status;
        this.price = price;
        this.time = LocalDate.now();
        this.detail = detail;
        this.cancelReser = cancelReser;
        this.member_id = member_id;

        // this.time = LocalDate.now();
    }
}