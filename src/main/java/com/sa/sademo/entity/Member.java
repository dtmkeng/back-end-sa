package com.sa.sademo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.*;
import java.util.*;
import java.time.LocalDate;
@Entity  
@Data  
@Table(name="Member") 
public class Member {

@Id  
@NotNull
private String memberId;
@NotNull
private String  username;
@NotNull
private String  name;
@NotNull
private String  email;
private String  phone_number;

@NotNull
private String password;
// private LocalDate date;


private Member() {}
public Member(String memberId,String  username,String password, String  name, String  email, String  phone_number){
                this.memberId = memberId;
                this.username = username;
                this.password = password;
                this.name = name;
                this.email= email;
                this.phone_number = phone_number;
 }
}