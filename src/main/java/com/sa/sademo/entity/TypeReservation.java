package sut.sa.g16.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import java.util.*;

@Entity  
@Data  
@Table(name="TypeReservation") 
public class TypeReservation {

@Id  
private String typereservationId;

private String  typeName;


private TypeReservation() {}

public TypeReservation(String typereservationId, String  typeName) { 
        this.typereservationId = typereservationId;
        this.typeName = typeName;
    }
}