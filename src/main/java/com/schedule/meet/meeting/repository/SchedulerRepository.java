package com.schedule.meet.meeting.repository;

import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SchedulerRepository<P> extends CrudRepository<Scheduler, Long> {

    @Query(value = "Select * from scheduler where start_time<:endTime and end_time>:startTime and room_id=:roomId", nativeQuery = true)
    List<Scheduler> findByTime(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime,  @Param("roomId") Integer roomId);


    @Query(value = "Select * from scheduler where start_time<:endTime and end_time>:startTime", nativeQuery = true)
    List<Scheduler> findByTime(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    List<Scheduler> findByUserId(Long userId);






}
