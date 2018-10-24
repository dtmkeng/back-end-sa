package sut.sa.g16.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table ( name = "TypeEquipment")
public class TypeEquipment {
    @Id
    @SequenceGenerator(name="type_seq",sequenceName="type_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="type_seq")
    @Column(name="TypeEqu_ID",unique = true, nullable = false)
    private @NonNull Long typeEquId;
    private @NonNull String equipmentType;

    public Long getTypeEquId() {
        return typeEquId;
    }

    public void setTypeEquId(Long typeEquId) {
        this.typeEquId = typeEquId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }
}

