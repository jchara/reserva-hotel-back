package gia.utp.primerproyecto.primerproyecto.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDTO {
    private Long id;
    private Long roomNumber;
    private Long price;
    private String roomType;
    private Long bedsNumber;
    private Long hotelId;
}
