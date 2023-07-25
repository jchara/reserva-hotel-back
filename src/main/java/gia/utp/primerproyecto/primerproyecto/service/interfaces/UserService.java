package gia.utp.primerproyecto.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.primerproyecto.model.entities.UserPK;
import gia.utp.primerproyecto.primerproyecto.web.dto.UserDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserByEmail(String email);

    UserDTO getUser(UserPK userPK);

    UserDTO updateUser(UserPK id, UserDTO userDTO);

    DeleteResponse deleteUser(UserPK id);
}
