package com.sa.sademo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;
import java.util.*;

@Entity  
@Data  
@Table(name="Reservation") 
public class Reservation {

@Id  
@GeneratedValue
@NonNull   
private Long reser_id;
@NotNull
private Date  time;
@NotNull
private String  status;
@NotNull
private int price; 

@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "cancelReser_id")
private CancelReser cancelReser;

private Reservation() {}

public Reservation(Long reser_id, Date  time,  String  status,int price) { 
        this.reser_id = reser_id;
        this.time  = time;
        this.status = status;
        this.price = price;
    }
}