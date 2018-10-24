package sut.sa.g16.model;
import lombok.*;
import java.util.*;
@Data
public class ReservationData {

    private  Long idstudio;
    private  Long idphotographer;
    private  Long memberid;
    private  Date date;
    private  Long typetimeid;
    private  Double price;

}
