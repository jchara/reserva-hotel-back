package gia.utp.primerproyecto.primerproyecto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @EmbeddedId
    private ReservationPK id;
    private Integer holderDni;
    private Date reservationDate;
    private Date startDate;
    private Date endDate;
    private Integer numberOfRooms;

    @MapsId("idHotel")
    @OneToOne
    private HotelEntity hotel;

    @MapsId("idUser")
    @OneToOne
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    private HotelEntity habilitationCode;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<RoomEntity> rooms;

}
