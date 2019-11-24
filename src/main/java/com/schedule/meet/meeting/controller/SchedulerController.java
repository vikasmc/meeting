package com.schedule.meet.meeting.controller;

import com.schedule.meet.meeting.entity.Room_list;
import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.service.RoomService;
import com.schedule.meet.meeting.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @Autowired
    private RoomService roomService;


    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public ResponseEntity<List<Scheduler>> getPersoneByName() {
        List<Scheduler> allPersons = schedulerService.getAllSchedule();
        return ResponseEntity.ok(allPersons);
    }


    @RequestMapping(value = "/schedule/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crateUser(@RequestBody Scheduler scheduler) {
        try {
            Room_list room_list = roomService.geRoomsByName(scheduler.getRoomName());
            scheduler.setRoomId(room_list.getRoomId());
            schedulerService.addSchedule(scheduler);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/schedule/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getScheduleUser(@RequestBody Scheduler scheduler) {
        try {
            schedulerService.addSchedule(scheduler);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
