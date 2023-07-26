package gia.utp.primerproyecto.primerproyecto.service.implementations;

import gia.utp.primerproyecto.primerproyecto.model.entities.RoomEntity;
import gia.utp.primerproyecto.primerproyecto.model.repository.RoomRepository;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.RoomService;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import gia.utp.primerproyecto.primerproyecto.web.dto.RoomDTO;
import gia.utp.primerproyecto.primerproyecto.web.exceptions.types.BadRequestException;
import gia.utp.primerproyecto.primerproyecto.web.exceptions.types.NotFoundException;
import gia.utp.primerproyecto.primerproyecto.web.exceptions.types.ValidationException;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private  final ModelMapper modelMapper;

    public RoomServiceImpl(RoomRepository roomRepository, ModelMapper modelMapper){
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        RoomEntity room = roomRepository.findByRoomNumber(roomDTO.getRoomNumber());

        if (room != null) {
            throw new BadRequestException("La habitacion " + roomDTO.getRoomNumber() +  " ya existe");
        }

        RoomEntity roomEntity = modelMapper.map(roomDTO, RoomEntity.class);
        roomEntity = roomRepository.save(roomEntity);
        return modelMapper.map(roomEntity, RoomDTO.class);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        List<RoomEntity> roomEntities = roomRepository.findAll();

        return  roomEntities.stream().map(
                roomEntity -> modelMapper.map(roomEntity, RoomDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public RoomDTO getRoom(Long id) {
        RoomEntity roomEntity = roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La habitacion con el id " + id +  " no se encuentra"));
        return modelMapper.map(roomEntity, RoomDTO.class);
    }

    @Override
    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        RoomEntity existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La habitacion con el id: " + id + " no se encuentra"));

            modelMapper.map(roomDTO, existingRoom);
            RoomEntity updatedRoomEntity = roomRepository.save(existingRoom);
            return modelMapper.map(updatedRoomEntity, RoomDTO.class);
    }

    @Override
    public DeleteResponse deleteRoom(Long id) {
        try {
            roomRepository.deleteById(id);

            return DeleteResponse.builder()
                    .message("La habitacion fue borrada con exito")
                    .status(true)
                    .build();

        } catch (EmptyResultDataAccessException ex) {
            throw new NotFoundException("La habitacion  con el id " + id +  " no se encuentra");
        }
    }
}
