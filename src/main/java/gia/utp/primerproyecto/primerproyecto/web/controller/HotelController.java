package gia.utp.primerproyecto.primerproyecto.web.controller;

import gia.utp.primerproyecto.primerproyecto.service.interfaces.HotelService;
import gia.utp.primerproyecto.primerproyecto.web.dto.HotelDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping("v1/hotels")
public class HotelController {

    private final HotelService hotelService;
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping()
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
        return new ResponseEntity<>(hotelService.createHotel(hotelDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public  ResponseEntity<List<HotelDTO>> getAllHotel(){
        return new ResponseEntity<>(hotelService.getAllHotel(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<HotelDTO> getHotel(@PathVariable Long id){
        return new ResponseEntity<>(hotelService.getHotel(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO){
        HotelDTO updatedHotel = hotelService.updateHotel(id, hotelDTO);
        return new ResponseEntity<>(updatedHotel, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<DeleteResponse> deleteHotel(@PathVariable Long id){
        DeleteResponse deleteResponse = hotelService.deleteHotel(id);
        return new ResponseEntity<>(deleteResponse,HttpStatus.ACCEPTED);
    }

}
