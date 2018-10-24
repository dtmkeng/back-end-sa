package sut.sa.g16.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@Getter
@Setter
@Table (name = " CATEGORY ")
public class Category {
    @Id
    @SequenceGenerator(name="categoryid_seq",sequenceName="categoryid_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categoryid_seq")
    private @NonNull Long categoryid;
    private @NonNull String typework;

    //One To Many with Rooms_Furniture_ManyToMany

    protected Category(){

    }
    public Category( String typework){
        this.typework = typework;
    }
    public Long getCategoryid() {
        return categoryid;
    }
    public String getTypework() {
        return typework;
    }
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }
    public void setTypework(String typework) {
        this.typework = typework;
    }
}


