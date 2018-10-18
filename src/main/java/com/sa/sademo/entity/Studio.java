package sut.sa.g16.entity;

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
@Table(name="Studio") 
public class Studio {

@Id  
@NotNull
@SequenceGenerator(name="studioId_seq",sequenceName="studioId_seq")               
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="studioId_seq")    
private Long studioId;
@NotNull
private String  name;
@NotNull
private String  detail;
@NotNull
private String  phonenumber;
private Double price;
private Studio() {}

public Studio(String  name,  String  detail, String  phonenumber,Double price) { 
        this.name = name;
        this.detail  = detail;
        this.phonenumber = phonenumber;
        this.price = price;
    }
}