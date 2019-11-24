package com.schedule.meet.meeting.entity;

import javax.persistence.*;

@Entity
@Table(name = "enrollment", schema = "public")
public class Enrollment {

    @Column(name = "scheduler_id", nullable = false)
    private Long schedulerId;
    @Column(name = "user_Id", nullable = false)
    private Long userId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enrollment_generator")
    @SequenceGenerator(name = "enrollment_generator", sequenceName = "enrollmentsequence", allocationSize = 1)
    @Column(name = "enrollment_id", nullable = false)
    private Integer enrollmentId;

    public Long getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(Long schedulerId) {
        this.schedulerId = schedulerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }
}
