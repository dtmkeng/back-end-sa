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
@Table(name="Photographer") 
public class Photographer {

@Id  
@NotNull   
private String photograpId;
@NonNull
private String  name;
@NotNull
private String  detail;
@NotNull
private String  phonenumber;



private Photographer() {}

public Photographer(String photograpId, String  name, String  detail, String  phonenumber ) { 
        this.photograpId = photograpId;
        this.name  = name;
        this.detail = detail;
        this.phonenumber = phonenumber;
    }
}