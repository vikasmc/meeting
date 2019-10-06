package com.schedule.meet.meeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "enrollment", schema = "public")
public class Enrollment {

    @Column(name = "scheduler_id", nullable = false)
    private Integer schedulerId;
    @Column(name = "user_Id", nullable = false)
    private Integer userId;

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
}
