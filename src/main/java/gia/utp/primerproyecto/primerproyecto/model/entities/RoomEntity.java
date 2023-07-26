package gia.utp.primerproyecto.primerproyecto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "rooms", uniqueConstraints = @UniqueConstraint(columnNames = "roomNumber"))
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long roomNumber;
    private Long price;
    private String roomType;
    private Long bedsNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private HotelEntity hotel;
}
