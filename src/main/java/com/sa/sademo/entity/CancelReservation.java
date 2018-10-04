package sut.sa.g16.entity;

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
@Table(name="CancelReservation") 
public class CancelReservation {

@Id  
@NotNull
private String cancelId;

@NotNull
private String  comment;
@NotNull
private String  title;
@NotNull
private LocalDate  date;

@OneToOne(fetch = FetchType.EAGER, optional = false,cascade =  CascadeType.ALL)
@JoinColumn(name = "reserId", nullable = false)
private Reservation reservation;

@ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
@JoinColumn(name="typereservationId")
private TypeReservation typeReservation;

@ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
@JoinColumn(name="photograpId")
private Photographer photographer;

@ManyToOne(fetch = FetchType.EAGER   , cascade = CascadeType.ALL)
@JoinColumn(name="studioId")
private Studio  studio;
 
private CancelReservation() {}

public CancelReservation(String cancelId, String  comment, String  title, Reservation reservation,Photographer photographer, Studio  studio, TypeReservation typeReservation) {     
        this.cancelId = cancelId;
        this.comment = comment;
        this.title  = title; 
        this.date = LocalDate.now();

        this.reservation = reservation;
        this.photographer = photographer;
        this.studio  = studio;
        this.typeReservation  = typeReservation;
    }
}