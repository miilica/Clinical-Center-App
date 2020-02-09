package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.dto.RoomDTO;
import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/rooms")
@CrossOrigin
public class RoomController {
    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RoomDTO>> getAll() {
        List<RoomDTO> roomsDTO =roomService.getAll();
        return new ResponseEntity<>(roomsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getEx")
    public ResponseEntity<List<RoomDTO>> getEx() {
        List<RoomDTO> roomsDTO = roomService.getEx();
        return new ResponseEntity<>(roomsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getOp")
    public ResponseEntity<List<RoomDTO>> getOp() {
        List<RoomDTO> roomsDTO = roomService.getEx();
        return new ResponseEntity<>(roomsDTO, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<RoomDTO> addRooms(@RequestBody RoomDTO roomDTO) {
        Room room = roomService.addRooms(roomDTO);
        return new ResponseEntity<>(new RoomDTO(room), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> deleteRoom(@PathVariable Long id) {
        roomService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<RoomDTO> editRoom (@RequestBody RoomDTO roomDTO) {
        Room room = roomService.editRoom(roomDTO);
        return new ResponseEntity<>(new RoomDTO(room), HttpStatus.OK);
    }
}
