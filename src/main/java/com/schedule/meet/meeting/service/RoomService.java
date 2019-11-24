package com.schedule.meet.meeting.service;

import com.schedule.meet.meeting.entity.Room_list;
import com.schedule.meet.meeting.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository<Room_list> RoomRepository;

    @Transactional
    public List<Room_list> getAllRooms() {
        return (List<Room_list>) RoomRepository.findAll();
    }


    @Transactional
    public Room_list geRoomsByName(String name) {
        List<Room_list> byRoomName = RoomRepository.findByRoomName(name);
        if(byRoomName.size()==0){
            return null;
        }
        return byRoomName.get(0);
    }


    @Transactional
    public Room_list getById(Long RoomId) {
        return RoomRepository.findById(RoomId).get();
    }

    @Transactional
    public boolean addRoom(Room_list scheduler) {
        return RoomRepository.save(scheduler) != null;
    }

    @Transactional
    public boolean updateRoom(Room_list person) {
        return RoomRepository.save(person) != null;
    }

}
