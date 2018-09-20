package com.sa.sademo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.*;
import java.util.*;
import java.time.LocalDate;

@Entity  
@Data  
@Table(name="CancelReser") 
public class CancelReser {

@Id  
@NotNull
private String cancelId;

@NotNull
private String  comment;
@NotNull
private String  title;
@NotNull
private LocalDate  date_submit;

@OneToOne(fetch = FetchType.LAZY, optional = false,cascade =  CascadeType.ALL)
@JoinColumn(name = "reserId", nullable = false)
private Reservation reservation;

@ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
@JoinColumn(name="typeId")
private TypeReser typeReser;

@ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
@JoinColumn(name="photograpId")
private Photographer photographer;

@ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
@JoinColumn(name="studioId")
private Studio  studio;
 
private CancelReser() {}

public CancelReser(String cancelId, String  comment, String  title, Reservation reservation,Photographer photographer, Studio  studio, TypeReser typeReser) {     
        this.cancelId = cancelId;
        this.comment = comment;
        this.title  = title;
        this.date_submit = LocalDate.now();

        this.reservation = reservation;
        this.photographer = photographer;
        this.studio  = studio;
        this.typeReser  = typeReser;
    }
}