package gia.utp.primerproyecto.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.primerproyecto.web.dto.HotelDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;

import java.util.List;

public interface HotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    List<HotelDTO> getAllHotel();

    HotelDTO getHotel(Long id);

    HotelDTO updateHotel(Long id, HotelDTO hotelDTO);

    DeleteResponse deleteHotel(Long id);
}
