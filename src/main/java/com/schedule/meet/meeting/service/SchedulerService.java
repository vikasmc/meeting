package com.schedule.meet.meeting.service;

import com.schedule.meet.meeting.entity.Scheduler;
import com.schedule.meet.meeting.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchedulerService {

    @Autowired
    private SchedulerRepository<Scheduler> userRepository;

    @Transactional
    public List<Scheduler> getAllSchedule() {
        return (List<Scheduler>) userRepository.findAll();
    }


    @Transactional
    public Scheduler getById(Long scheduleId) {
        return userRepository.findById(scheduleId).get();
    }

    @Transactional
    public boolean addSchedule(Scheduler scheduler) {
        List<Scheduler> conflictSchedule = userRepository.findByTime(scheduler.getStartTime(), scheduler.getEndTime(),scheduler.getRoomId());
        if(conflictSchedule.size()>0){
            System.out.println("Schedule Conflicts");
            throw new RuntimeException("Schedule Conflicts");
        }
        return userRepository.save(scheduler) != null;
    }

    @Transactional
    public boolean updateSchedule(Scheduler person) {
        return userRepository.save(person) != null;
    }

}
