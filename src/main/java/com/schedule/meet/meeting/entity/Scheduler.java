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
    private Long schedulerId;
    @Column(name="room_id", nullable=false)
    private Long roomId;
    @Column(name="user_Id", nullable=false)
    private Long userId;
    @Column(name="start_time")
    private LocalDateTime startTime;
    @Column(name="end_time")
    private LocalDateTime endTime;
    @Column(name="topic_name", nullable=false)
    private String topicName;
    @Column(name="topic_description", nullable=false)
    private String topicDescription;
    @Transient
    private String roomName;


    public Long getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(Long schedulerId) {
        this.schedulerId = schedulerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
