package sut.sa.g16.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.*;


@Entity
@Data
@Getter @Setter
// @NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table ( name = "BookingEquipment")
public class BookingEquipment {
    @Id
    @SequenceGenerator(name="booking_seq",sequenceName="booking_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="booking_seq")
    @Column(name="Booking_ID",unique = true, nullable = false)
    private @NonNull Long bookingId;
    private @NonNull String equipmentName;
    private @NonNull String equipmentType;
    private @NonNull String equipmentBrand;
    private @NonNull int equipmentPrice;
    private @NonNull int totalDay;
    private @NonNull Date dateStart;
    private @NonNull Date dateEnd;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    private Member member;
    public BookingEquipment(){}
    public BookingEquipment(String equipmentName,String equipmentType,String equipmentBrand,
                            int equipmentPrice,int totalDay,Date dateStart,Date dateEnd){

        this.equipmentName = equipmentName;
        this.equipmentType=equipmentType;
        this.equipmentBrand = equipmentBrand;
        this.equipmentPrice = equipmentPrice;
        this.totalDay = totalDay;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;

    }
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentBrand() {
        return equipmentBrand;
    }

    public void setEquipmentBrand(String equipmentBrand) {
        this.equipmentBrand = equipmentBrand;
    }

    public int getEquipmentPrice() { return equipmentPrice; }

    public void setEquipmentPrice(int equipmentPrice) { this.equipmentPrice = equipmentPrice; }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}