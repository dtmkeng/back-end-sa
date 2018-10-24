package sut.sa.g16.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table ( name = "Equipment")
public class Equipment {
    @Id
    @SequenceGenerator(name="id_seq",sequenceName="id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_seq")
    @Column(name="ID",unique = true, nullable = false)
    private @NonNull Long equipmentId;
    private @NonNull String equipmentName;
    private @NonNull int equipmentPrice;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookingEquipment.class)
    @JoinColumn(name = "bookingId")
    @JsonIgnore
    private BookingEquipment bookingEquipment;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BrandEquipment.class)
    @JoinColumn(name = "brandEquId")
    @JsonIgnore
    private BrandEquipment brandEquipment;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeEquipment.class)
    @JoinColumn(name = "typeEquId")
    @JsonIgnore
    private TypeEquipment typeEquipment;

    public Long getEquipmentId(){ return equipmentId; }
    public  void setEquipmentId(Long EquipmentId) { this.equipmentId = EquipmentId; }

    public String getEquipmentName(){ return equipmentName; }
    public  void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }

    public int getEquipmentPrice() { return equipmentPrice; }
    public void setEquipmentPrice(int equipmentPrice) { this.equipmentPrice = equipmentPrice; }

    public TypeEquipment getTypeEquipment() {
        return typeEquipment;
    }
    public void setTypeEquipment(TypeEquipment typeEquipment) { this.typeEquipment = typeEquipment; }

    public BrandEquipment getBrandEquipment() {
        return brandEquipment;
    }
    public void setBrandEquipment(BrandEquipment brandEquipment) {
        this.brandEquipment = brandEquipment;
    }

    public BookingEquipment getBookingEquipment() {
        return bookingEquipment;
    }
    public void setBookingEquipment(BookingEquipment bookingEquipment) {
        this.bookingEquipment = bookingEquipment;
    }


}