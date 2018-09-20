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
private String typeId;

private String  type_name;


private TypeReser() {}

public TypeReser(String typeId, String  type_name) { 
        this.typeId = typeId;
        this.type_name = type_name;
    }
}