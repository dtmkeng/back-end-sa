package sut.sa.g16.entity;
import  javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = " TypeDelivery ")
public class TypeDelivery{
    @Id
    @SequenceGenerator(name="typeDeliveryId_seq",sequenceName="typeDeliveryId_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="typeDeliveryId_seq")
    private @NonNull Long typeDaliveryId;
    private @NonNull String typeDalivery;

    protected TypeDelivery(){
    }
    public TypeDelivery(String typeDalivery){
        this.typeDalivery=typeDalivery;

    }



}