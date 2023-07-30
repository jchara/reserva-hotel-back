package gia.utp.primerproyecto.primerproyecto.web.controller;

import gia.utp.primerproyecto.primerproyecto.service.interfaces.RoomService;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import gia.utp.primerproyecto.primerproyecto.web.dto.RoomDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin({"*"})
@RestController
@RequestMapping("v1/rooms")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;

    }

    @PostMapping()
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        return new ResponseEntity<>(roomService.createRoom(roomDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public  ResponseEntity<List<RoomDTO>> getAllRooms(){
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<RoomDTO> getRoom(@PathVariable Long id){
        return new ResponseEntity<>(roomService.getRoom(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO){
        RoomDTO updatedRoom = roomService.updateRoom(id, roomDTO);
        return new ResponseEntity<>(updatedRoom, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<DeleteResponse> deleteRoom(@PathVariable Long id){
        DeleteResponse deleteResponse = roomService.deleteRoom(id);
        return new ResponseEntity<>(deleteResponse,HttpStatus.ACCEPTED);
    }
}