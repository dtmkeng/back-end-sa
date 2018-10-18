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
@SequenceGenerator(name="resevationId_seq",sequenceName="resevationId_seq")               
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="resevationId_seq")     
private Long reservationId;

@NotNull
@ManyToOne
private Photographer photographer;

@NotNull
@ManyToOne
private Studio studio;

@NotNull
@ManyToOne
private Timetype  time;


@NotNull
private Date  date;


@NotNull
@ManyToOne 
private Member memberId;

@NotNull
private Double price; 



@OneToOne(fetch = FetchType.LAZY)
private CancelReservation cancelReservation;

private Reservation() {}

public Reservation(Double price,Member memberId,Photographer photographer,Studio studio,Timetype time,Date  date) { 
        this.price = price;
        this.time = time;
        this.memberId = memberId;
        this.studio = studio;
        this.photographer = photographer;
        this.date = date;
    }
}