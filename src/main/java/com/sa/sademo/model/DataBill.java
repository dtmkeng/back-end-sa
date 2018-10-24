package sut.sa.g16.model;
import lombok.*;
import java.util.Date;
@Data
public class DataBill {
    private String name;
    private String phonenumber;
    private Date date;
    private Integer price;

    private Long reserId;
    private Long bookingequId;
    private Long memberId;
    private Long typeId;
}
