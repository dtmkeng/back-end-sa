package sut.sa.g16.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = " ADMIN ")
public class Admin {
    @Id
    @SequenceGenerator(name="adminid_seq",sequenceName="adminid_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adminid_seq")
    private @NonNull Long adminid;
    private @NonNull String username;
    private @NonNull String password;

    //One To Many with Rooms_Furniture_ManyToMany
    protected Admin(){

    }
    public Admin(String username,String password ){
        this.username = username;
        this.password = password;
    }
}


