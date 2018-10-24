package sut.sa.g16.entity;
import  javax.persistence.*;
import lombok.*;
@Entity
@Data
@Table (name = " SendPhoto ")
public class SendPhoto {
    @Id
    @SequenceGenerator(name="sendIdId_seq",sequenceName="sendIdId_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sendIdId_seq")
    private @NonNull Long sendId;
    private @NonNull String name;
    private @NonNull String email;
    private @NonNull String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Members member;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeDaliveryId")
    private TypeDelivery typeDelivery;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typePhotoId")
    private TypePhoto typePhoto;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeSizeId")
    private TypeSize typeSize;

    
    public SendPhoto(Members member, Reservation reservationId, TypeDelivery typeDeliveryId, TypePhoto typePhotoId, TypeSize typeSizeId,String name,
    String email,String address){
        this.member=member;
        this.reservation=reservationId;
        this.typeDelivery=typeDeliveryId;
        this.typePhoto=typePhotoId;
        this.typeSize=typeSizeId;

        this.name = name;
        this.email = email;
        this.address = address;
    }
    @Override
    public String toString() {
        return "SendPhotos [ sendId = " + sendId + ", name = " + name + ", email = " + email + "address, = "+ address +"]";
    }
    public Long getSendId() {
        return sendId;
    }
    public void setSendId(Long sendId) {
        this.sendId=sendId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address=address;
    }
}