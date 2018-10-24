package sut.sa.g16.model;
import lombok.*;
import java.util.Date;

@Data
public class ReservationData {

    private  Long idstudio;
    private  Long idphotographer;
    private  Long memberid;
    private  Date date;
    private  Long typetimeid;
    private  Double price;

}
