package sut.sa.g16.entity;
import  javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = " typePhoto ")
public class TypePhoto{
    @Id
    @SequenceGenerator(name="typePhotoId_seq",sequenceName="typePhotoId_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="typePhotoId_seq")
    private @NonNull Long typePhotoId;
    private @NonNull String typePhoto;

    protected TypePhoto(){
    }
    public TypePhoto(String typePhoto){
        
        this.typePhoto=typePhoto;

    }

    
}