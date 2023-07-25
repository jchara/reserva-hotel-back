package gia.utp.primerproyecto.primerproyecto.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolDTO {
    private Integer id;
    private String description;
    private List<UserDTO> userDTOS;
}
