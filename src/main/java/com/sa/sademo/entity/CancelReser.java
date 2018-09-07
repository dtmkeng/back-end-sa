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
@Table(name="CancelReser") 
public class CancelReser {

@Id  
@GeneratedValue 
@NotNull
private Long cancelReser_id;
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

public CancelReser(Long cancelReser_id, String  comment, String  title, Date  date_submit) { 
        this.cancelReser_id = cancelReser_id;
        this.comment = comment;
        this.title  = title;
        this.date_submit = date_submit;
    }
}