package sut.sa.g16.model;
import lombok.*;
import java.util.*;


@Data
public class DataSendPhoto {
    
    private Long memberId;
    private Long reservationId;

    private String name;
    private String email;
    private String address;


    
    private Long typeDeliveryId;
    private Long typePhotoId;
    private Long typeSizeId;
    
    


}