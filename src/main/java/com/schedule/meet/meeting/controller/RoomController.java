package com.schedule.meet.meeting.controller;

import com.schedule.meet.meeting.entity.Room_list;
import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;


    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ResponseEntity<List<Room_list>> getRooms() {
        List<Room_list> allPersons = roomService.getAllRooms();
        return ResponseEntity.ok(allPersons);
    }


    @RequestMapping(value = "/rooms/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crateUser(@RequestBody Room_list room_list) {
        Room_list room_list1 = roomService.geRoomsByName(room_list.getRoomName());
        if(room_list1!=null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        try{
            roomService.addRoom(room_list);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
