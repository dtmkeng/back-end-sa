package sut.sa.g16.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Data
@Table (name = " TIMETYPE ")
public class Timetype {
    
    @Id
    @SequenceGenerator(name="timetypeid_seq",sequenceName="timetypeid_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="timetypeid_seq")
    private @NonNull Long timetypeid;
    private @NonNull String time;

    //One TO Many with Rooms
  
   public Timetype(String time){
       this.time = time;

   }
  
}