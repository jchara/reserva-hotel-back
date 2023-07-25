package gia.utp.primerproyecto.primerproyecto.model.repository;

import gia.utp.primerproyecto.primerproyecto.model.entities.UserEntity;
import gia.utp.primerproyecto.primerproyecto.model.entities.UserPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, UserPK> {
    UserEntity findByEmail(String email);
}
