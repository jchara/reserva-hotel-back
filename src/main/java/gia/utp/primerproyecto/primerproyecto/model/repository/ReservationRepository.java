package gia.utp.primerproyecto.primerproyecto.model.repository;

import gia.utp.primerproyecto.primerproyecto.model.entities.ReservationEntity;
import gia.utp.primerproyecto.primerproyecto.model.entities.ReservationPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, ReservationPK>{
}
