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
private String studioId;
@NotNull
private String  name;
@NotNull
private String  detail;
@NotNull
private String  phonenumber;

private Studio() {}

public Studio(String studioId, String  name,  String  detail, String  phonenumber) { 
        this.studioId = studioId;
        this.name = name;
        this.detail  = detail;
        this.phonenumber = phonenumber;
    }
}