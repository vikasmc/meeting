package com.schedule.meet.meeting.repository;

import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SchedulerRepository<P> extends CrudRepository<Scheduler, Long> {

}
