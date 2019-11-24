package com.schedule.meet.meeting.repository;

import com.schedule.meet.meeting.entity.Enrollment;
import com.schedule.meet.meeting.entity.Role_list;
import com.schedule.meet.meeting.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnrollmentRepository<P> extends CrudRepository<Enrollment, Long> {


    List<Enrollment> findByuserId(Long user_Id);

    List<Enrollment> findByschedulerId(Long scheduler_id);

}
