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
@Table(name="Photographer") 
public class Photographer {

@Id  
@NotNull
@SequenceGenerator(name="photograpId_seq",sequenceName="photograpId_seq")               
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="photograpId_seq")  
private Long photograpId;
@NonNull
private String  name;
@NotNull
private String  detail;
@NotNull
private String  phonenumber;
private Double price; 
private Photographer() {}
public Photographer(String  name, String  detail, String  phonenumber,Double price) { 
        this.name  = name;
        this.detail = detail;
        this.phonenumber = phonenumber;
        this.price = price;
    }
}