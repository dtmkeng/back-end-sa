package com.sa.sademo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.*;
import java.util.*;
// import java.time.LocalDate;

@Entity  
@Data  
@Table(name="CancelReser") 
public class CancelReser {

@Id  
@GeneratedValue 
@NotNull
private String cancelId;

@NotNull
private String  comment;
@NotNull
private String  title;
@NotNull
private Date  date_submit;

@OneToOne(mappedBy = "cancelReser", cascade = CascadeType.ALL, 
          fetch = FetchType.LAZY, 
          optional = false)
private Reservation reservation;

@ManyToOne(fetch = FetchType.LAZY)
private Photographer photographer;

@ManyToOne(fetch= FetchType.LAZY)
private Studio  studio;
 
private CancelReser() {}

public CancelReser(String cancelId, String  comment, String  title) {     
        this.cancelId = cancelId;
        this.comment = comment;
        this.title  = title;
        // this.date_submit = LocalDate.now();
    }
}