package com.schedule.meet.meeting.controller;

import com.schedule.meet.meeting.domain.SearchResponse;
import com.schedule.meet.meeting.entity.Enrollment;
import com.schedule.meet.meeting.entity.Room_list;
import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.repository.UserRepository;
import com.schedule.meet.meeting.service.EnrolmentService;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EnrolmentController {

    @Autowired
    private EnrolmentService enrolmentService;

    @Autowired
    private SchedulerService schedulerService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserRepository<User> userRepository;


    @RequestMapping(value = "/enrolment", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> getRooms() {
        List<Enrollment> allPersons = enrolmentService.getAllEnrolment();
        return ResponseEntity.ok(allPersons);
    }

    @RequestMapping(value = "/enrolment/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchResponse>> getRoomsForUser(@RequestBody User user) {
        List<SearchResponse> searchResponsesList = new ArrayList<>();
        User byUserName = userRepository.findByUserName(user.getUserName()).get(0);
        List<Enrollment> allPersons = enrolmentService.getListBasedOnUserId(byUserName.getUserId());
        List<Long> collect = allPersons.stream().map(e -> e.getSchedulerId()).collect(Collectors.toList());
        List<Scheduler> byTime = schedulerService.findByTime(LocalDate.now().atTime(0, 0, 0), LocalDate.now().atTime(23, 59, 59));
        byTime = byTime.stream().filter(e->collect.contains(e.getSchedulerId())).collect(Collectors.toList());
        List<Long> collect1 = byTime.stream().map((e -> e.getSchedulerId())).collect(Collectors.toList());
        List<Scheduler> byUserId = schedulerService.findByTimeuserId(LocalDate.now().atTime(0, 0, 0), LocalDate.now().atTime(23, 59, 59),byUserName.getUserId());
        for (Scheduler scheduler : byUserId) {
            if(collect1.contains(scheduler.getSchedulerId())){
                continue;
            }
            byTime.add(scheduler);
        }
        List<Room_list> allRooms = roomService.getAllRooms();
        for (Scheduler schedule : byTime) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setEndTime(schedule.getEndTime().toString());
            searchResponse.setStartTime(schedule.getStartTime().toString());
            searchResponse.setTopic(schedule.getTopicName());
            searchResponse.setRoomName(allRooms.stream().filter(e -> e.getRoomId() == schedule.getRoomId()).findFirst().get().getRoomName());
            searchResponse.setPresenter(userRepository.findById(schedule.getUserId()).get().getUserName());
            searchResponsesList.add(searchResponse);
        }
        return ResponseEntity.ok(searchResponsesList);
    }


    @RequestMapping(value = "/enrolment/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crateUser(@RequestBody Enrollment room_list) {
        User user = userRepository.findById(room_list.getUserId()).get();
        int size = enrolmentService.getListBasedOnScheduleId(room_list.getSchedulerId()).size();
        Scheduler byId = schedulerService.getById(room_list.getSchedulerId());
        Room_list byId1 = roomService.getById(byId.getRoomId());
        if(byId1.getRoomSize()<=size){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        List<Long> collect = enrolmentService.getListBasedOnUserId(user.getUserId()).stream().map(e -> e.getSchedulerId()).distinct().collect(Collectors.toList());
        user.setScheduleList(collect);
        try{
            enrolmentService.addEnrolment(room_list);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok(user);
    }


    @RequestMapping(value = "/enrolment/user/scheduleIds", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Long>> getRoomsForSchedule(@RequestBody User user) {
        List<Enrollment> allPersons = enrolmentService.getListBasedOnUserId(user.getUserId());
        List<Long> collect = allPersons.stream().map(e -> e.getSchedulerId()).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }
}
