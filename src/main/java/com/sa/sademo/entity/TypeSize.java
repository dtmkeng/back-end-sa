package sut.sa.g16.entity;
import  javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = " typeSize ")
public class TypeSize{

    
    @Id
    @SequenceGenerator(name="typeSize_seq",sequenceName="typeSize_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="typeSize_seq")
    private @NonNull Long typeSizeId;
    private @NonNull String typeSize;

    protected TypeSize(){
    }
    public TypeSize(String typePhoto){
        
        this.typeSize=typePhoto;

    }

    
}