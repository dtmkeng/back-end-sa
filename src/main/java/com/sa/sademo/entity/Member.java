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
@Table(name="Member") 
public class Member {

@Id  
@GeneratedValue 
@NotNull
private Long member_id;
@NotNull
private String  username;
@NotNull
private String  name;
@NotNull
private String  email;
private String  phone_number;

private Member() {}

}