package com.schedule.meet.meeting.service;

import com.schedule.meet.meeting.entity.Enrollment;
import com.schedule.meet.meeting.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrolmentService {

    @Autowired
    private EnrollmentRepository<Enrollment> enrolmentRepository;

    @Transactional
    public List<Enrollment> getAllEnrolment() {
        return (List<Enrollment>) enrolmentRepository.findAll();
    }


    @Transactional
    public Enrollment getById(Long enrolmentId) {
        return enrolmentRepository.findById(enrolmentId).get();
    }

    @Transactional
    public boolean addEnrolment(Enrollment enrollment) {
        return enrolmentRepository.save(enrollment) != null;
    }

    @Transactional
    public boolean updateEnrolment(Enrollment enrollment) {
        return enrolmentRepository.save(enrollment) != null;
    }

    @Transactional
    public List<Enrollment> getListBasedOnUserId(Long userId){
        return enrolmentRepository.findByuserId(userId);
    }

}
