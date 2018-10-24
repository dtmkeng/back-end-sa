package sut.sa.g16.entity;
import javax.persistence.*;
import lombok.*;


import java.util.*;


@Entity
@Data
@Table (name = " WORKSCHUDULE ")
public class Workschudule {

    @Id

    @SequenceGenerator(name="workschuduleid_seq",sequenceName="workschuduleid_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="workschuduleid_seq")
    private @NonNull Long workschuduleid;
    private @NonNull Date date;
    private @NonNull String location;


    //Many To One with Photographer
    @ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "photographerId")
    private Photographer photographer;

    //Many To One with Timetype
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "timetypeid")
    private Timetype timetype;

    //Many to One with Admin
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "adminid")
    private Admin admin;


    protected Workschudule(){
    }
    public Workschudule(Date date,String location,Photographer photographer,Timetype timetype,Admin admin){


        this.date = date;
        this.location = location;
        this.photographer = photographer;
        this.timetype = timetype;
        this.admin = admin;
    }
   

}