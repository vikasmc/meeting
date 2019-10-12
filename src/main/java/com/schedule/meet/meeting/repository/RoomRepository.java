package com.schedule.meet.meeting.repository;

import com.schedule.meet.meeting.entity.Room_list;
import com.schedule.meet.meeting.entity.Scheduler;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository<P> extends CrudRepository<Room_list, Long> {

}
