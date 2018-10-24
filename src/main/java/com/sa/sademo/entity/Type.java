package sut.sa.g16.entity;
import lombok.Data;
import lombok.NonNull;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = " Type ")

public class Type {
    @Id
    @SequenceGenerator(name="typeId_seq",sequenceName="typeId_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="typeId_seq")

    private @NonNull Long typeId;
    private @NonNull String type;



    protected Type() {
    }

    public Type(String type) {
        this.type = type;

    }
}