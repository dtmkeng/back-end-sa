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


@ManyToOne(fetch = FetchType.EAGER )
@JoinColumn(name= "photograpId")
private Photographer photographer;


@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name= "studioId")
private Studio studio;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name= "timetypeid")
private Timetype timetype;


@NotNull
private Date  date;


@NotNull
@ManyToOne 
private Members memberId;

@NotNull
private Double price; 



@OneToOne(fetch = FetchType.EAGER)
private CancelReservation cancelReservation;

private Reservation() {}

public Reservation(Double price,Members memberId,Photographer photographer,Studio studio,Timetype timetype,Date  date) { 
        this.price = price;
        this.timetype = timetype;
        this.memberId = memberId;
        this.studio = studio;
        this.photographer = photographer;
        this.date = date;
    }
}