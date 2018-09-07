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
@Table(name="Studio") 
public class Studio {

@Id  
@GeneratedValue
@NotNull   
private Long studio_id;
@NotNull
private String  name;
@NotNull
private String  detail;
@NotNull
private String  phonenumber;

private Studio() {}

public Studio(Long studio_id, String  name,  String  detail, String  phonenumber) { 
        this.studio_id = studio_id;
        this.name = name;
        this.detail  = detail;
        this.phonenumber = phonenumber;
    }
}