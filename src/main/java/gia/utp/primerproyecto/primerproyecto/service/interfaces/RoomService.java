package gia.utp.primerproyecto.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import gia.utp.primerproyecto.primerproyecto.web.dto.RoomDTO;

import java.util.List;

public interface RoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    List<RoomDTO> getAllRooms();

      RoomDTO getRoom(Long id);

    RoomDTO updateRoom(Long id, RoomDTO roomDTO);

    DeleteResponse deleteRoom(Long id);
}
