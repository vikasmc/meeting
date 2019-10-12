package com.schedule.meet.meeting.entity;

import javax.persistence.*;

//@Entity
//@Table(name = "enrollment", schema = "public")
public class Enrollment {

    @Column(name = "scheduler_id", nullable = false)
    private Integer schedulerId;
    @Column(name = "user_Id", nullable = false)
    private Integer userId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enrollment_generator")
    @SequenceGenerator(name = "enrollment_generator", sequenceName = "enrollmentsequence", allocationSize = 1)
    @Column(name = "enrollment_id", nullable = false)
    private Integer enrollmentId;

    public Integer getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(Integer schedulerId) {
        this.schedulerId = schedulerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }
}
