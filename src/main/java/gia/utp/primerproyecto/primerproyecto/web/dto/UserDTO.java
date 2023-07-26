package gia.utp.primerproyecto.primerproyecto.web.dto;

import gia.utp.primerproyecto.primerproyecto.model.entities.RolEntity;
import gia.utp.primerproyecto.primerproyecto.model.entities.UserPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private UserPK id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private Long rolId;
}
