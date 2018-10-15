package sut.sa.g16.entity;

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
@Table(name="Members") 
public class Member {

@Id  
@NotNull
@SequenceGenerator(name="member_seq",sequenceName="member_seq")               
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="member_seq")  
private Long memberId;
@NotNull
private String  username;
@NotNull
private String  name;
@NotNull
private String  email;
private String  phonenumber;

@NotNull
private String password;

// private LocalDate date;


private Member() {}
public Member( String username,String password, String  name, String  email, String  phonenumber){
                this.username = username;
                this.password = password;
                this.name = name;
                this.email= email;
                this.phonenumber = phonenumber;
 }
}