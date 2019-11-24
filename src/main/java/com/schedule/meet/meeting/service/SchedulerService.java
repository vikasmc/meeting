package com.schedule.meet.meeting.service;

import com.schedule.meet.meeting.entity.Room_list;
import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SchedulerService {

    @Autowired
    private SchedulerRepository<Scheduler> scheduleRepository;

    @Transactional
    public List<Scheduler> getAllSchedule() {
        return (List<Scheduler>) scheduleRepository.findAll();
    }


    @Transactional
    public List<Scheduler> findByTime(LocalDateTime startTime,LocalDateTime endTime) {
        return  scheduleRepository.findByTime(startTime, endTime);
    }


    @Transactional
    public List<Scheduler> findByUserId(Long userId){
        return scheduleRepository.findByUserId(userId);
    }

    @Transactional
    public Scheduler getById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).get();
    }





    @Transactional
    public boolean addSchedule(Scheduler scheduler) {
        List<Scheduler> conflictSchedule = scheduleRepository.findByTime(scheduler.getStartTime(), scheduler.getEndTime(),scheduler.getRoomId());
        if(conflictSchedule.size()>0){
            System.out.println("Schedule Conflicts");
            throw new RuntimeException("Schedule Conflicts");
        }
        return scheduleRepository.save(scheduler) != null;
    }

    @Transactional
    public boolean updateSchedule(Scheduler person) {
        return scheduleRepository.save(person) != null;
    }


}
