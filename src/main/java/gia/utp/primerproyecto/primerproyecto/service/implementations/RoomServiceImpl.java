package gia.utp.primerproyecto.primerproyecto.service.implementations;

import gia.utp.primerproyecto.primerproyecto.model.entities.HotelEntity;
import gia.utp.primerproyecto.primerproyecto.model.entities.RoomEntity;
import gia.utp.primerproyecto.primerproyecto.model.repository.HotelRepository;
import gia.utp.primerproyecto.primerproyecto.model.repository.RoomRepository;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.RoomService;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import gia.utp.primerproyecto.primerproyecto.web.dto.RoomDTO;
import gia.utp.primerproyecto.primerproyecto.web.exceptions.types.BadRequestException;
import gia.utp.primerproyecto.primerproyecto.web.exceptions.types.NoContentException;
import gia.utp.primerproyecto.primerproyecto.web.exceptions.types.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private  final ModelMapper modelMapper;
    private final HotelRepository hotelRepository;

    public RoomServiceImpl(RoomRepository roomRepository, ModelMapper modelMapper, HotelRepository hotelRepository){
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
        this.hotelRepository = hotelRepository;
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
                .orElseThrow(() -> new NoContentException("La habitacion con el id " + id +  " no se encuentra"));
        return modelMapper.map(roomEntity, RoomDTO.class);
    }

    @Override
    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        RoomEntity existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La habitacion con el id: " + id + " no se encuentra"));

        if (!existingRoom.getHotel().getId().equals(roomDTO.getHotelId())) {
            HotelEntity newHotel = hotelRepository.findById(roomDTO.getHotelId())
                    .orElseThrow(() -> new NotFoundException("El hotel con el id: " + roomDTO.getHotelId() + " no se encuentra"));

            existingRoom.setHotel(newHotel);
        }

        existingRoom.setRoomNumber(roomDTO.getRoomNumber());
        existingRoom.setPrice(roomDTO.getPrice());
        existingRoom.setRoomType(roomDTO.getRoomType());
        existingRoom.setBedsNumber(roomDTO.getBedsNumber());

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
