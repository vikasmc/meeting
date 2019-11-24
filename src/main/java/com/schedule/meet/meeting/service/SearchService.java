package com.schedule.meet.meeting.service;

import com.schedule.meet.meeting.domain.SearchRequest;
import com.schedule.meet.meeting.domain.SearchResponse;
import com.schedule.meet.meeting.entity.Room_list;
import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private SchedulerService schedulerService;


    @Transactional
    public List<SearchResponse> search(SearchRequest searchRequest) {
        List<Scheduler> allSchedule = null;
        List<SearchResponse> searchResponsesList = new ArrayList<>();
        if (searchRequest.getDay() == null) {
            allSchedule = schedulerService.getAllSchedule();
        } else {
            allSchedule = schedulerService.findByTime(searchRequest.getDay().atTime(LocalTime.of(0, 0, 0)), searchRequest.getDay().atTime(LocalTime.of(23, 59, 59)));
        }
        List<Room_list> allRooms = roomService.getAllRooms();
        if(searchRequest.getRoomName()!=null && !searchRequest.getRoomName().equalsIgnoreCase("Default") ){
            Room_list room_list = roomService.geRoomsByName(searchRequest.getRoomName());
            if(room_list!=null)
            allSchedule = allSchedule.stream().filter(e-> e.getRoomId() ==room_list.getRoomId()).collect(Collectors.toList());
        }
        if(searchRequest.getPresenter()!=null && !searchRequest.getPresenter().isBlank() && !searchRequest.getPresenter().isEmpty()){
            User byName = userService.findByName(searchRequest.getPresenter());
            if(byName!=null)
            allSchedule = allSchedule.stream().filter(e-> e.getUserId() ==byName.getUserId()).collect(Collectors.toList());
            else{
                allSchedule = new ArrayList<>();
            }
        }
        for (Scheduler schedule : allSchedule) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setScheduleId(schedule.getSchedulerId());
            searchResponse.setEndTime(schedule.getEndTime().toString());
            searchResponse.setStartTime(schedule.getStartTime().toString());
            searchResponse.setTopic(schedule.getTopicName());
            searchResponse.setRoomName(allRooms.stream().filter(e -> e.getRoomId() == schedule.getRoomId()).findFirst().get().getRoomName());
            searchResponse.setPresenter(userRepository.findById(schedule.getUserId()).get().getUserName());
            searchResponsesList.add(searchResponse);
        }
        return searchResponsesList;

    }

}
