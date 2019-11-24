package com.schedule.meet.meeting.repository;

import com.schedule.meet.meeting.entity.Room_list;
import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository<P> extends CrudRepository<Room_list, Long> {

    List<Room_list> findByRoomName(String roomName);

}
