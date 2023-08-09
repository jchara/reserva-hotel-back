package gia.utp.primerproyecto.primerproyecto.model.repository;

import gia.utp.primerproyecto.primerproyecto.model.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    RoomEntity findByRoomNumber(Long findByroomNumber);

}
