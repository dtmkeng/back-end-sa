package sut.sa.g16.entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table (name = " CATEGORYWORK ")
public class CategoryWork {
    @Id

    @SequenceGenerator(name="catworkid_seq",sequenceName="catworkid_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="catworkid_seq")
    private @NonNull Long catworkid;

    //Many To One With Workschudule
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workschuduleid")
    private Workschudule hWork;

    //Many To One With Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= " categoryid ")
    private Category rCate;


    public CategoryWork(){

    }
    public CategoryWork(Workschudule hWork,Category rCate){
        this.hWork = hWork;

        this.rCate = rCate;
    }
    public Long getCatworkid() {
        return catworkid;
    }
    public void setCatworkid(Long catworkid) {
        this.catworkid = catworkid;
    }
    public Workschudule getHWork() {
        return hWork;
    }
    public void setHWork(Workschudule hWork) {
        this.hWork = hWork;
    }
    public Category getRCate() {
        return rCate;
    }
    public void setRCate(Category rCate) {
        this.rCate = rCate;
    }
}



