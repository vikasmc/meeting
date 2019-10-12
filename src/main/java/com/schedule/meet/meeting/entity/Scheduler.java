package com.schedule.meet.meeting.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scheduler", schema = "public")
public class Scheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scheduler_generator")
    @SequenceGenerator(name = "scheduler_generator", sequenceName = "schedulersequence", allocationSize = 1)
    @Column(name="scheduler_id", nullable=false)
    private Integer schedulerId;
    @Column(name="room_id", nullable=false)
    private Integer roomId;
    @Column(name="user_Id", nullable=false)
    private Integer userId;
    @Column(name="start_time", nullable=false)
    private LocalDateTime startTime;
    @Column(name="end_time", nullable=false)
    private LocalDateTime endTime;
    @Column(name="topic_name", nullable=false)
    private String topicName;
    @Column(name="topic_description", nullable=false)
    private String topicDescription;


    public Integer getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(Integer schedulerId) {
        this.schedulerId = schedulerId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }
}
