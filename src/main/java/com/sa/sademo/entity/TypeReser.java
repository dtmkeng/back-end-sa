package com.sa.sademo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import java.util.*;

@Entity  
@Data  
@Table(name="TypeReser") 
public class TypeReser {

@Id  
@GeneratedValue   
private Long type_id;
private String  type_name;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name= "cancelReser_id") 
private CancelReser cancelReser;
private TypeReser() {}

public TypeReser(Long type_id, String  type_name) { 
        this.type_id = type_id;
        this.type_name = type_name;
    }
}