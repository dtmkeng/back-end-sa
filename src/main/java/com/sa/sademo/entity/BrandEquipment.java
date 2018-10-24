package sut.sa.g16.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table ( name = "BrandEquipment")

public class BrandEquipment {
    @Id
    @SequenceGenerator(name="brand_seq",sequenceName="brand_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="brand_seq")
    @Column(name="BrandEqu_ID",unique = true, nullable = false)
    private @NonNull Long brandEquId;
    private @NonNull String equipmentBrand;

    public Long getBrandEquId() {
        return brandEquId;
    }

    public void setBrandEquId(Long brandEquId) {
        this.brandEquId = brandEquId;
    }

    public String getEquipmentBrand() {
        return equipmentBrand;
    }

    public void setEquipmentBrand(String equipmentBrand) {
        this.equipmentBrand = equipmentBrand;
    }
}

