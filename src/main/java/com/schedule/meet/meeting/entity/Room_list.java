package com.schedule.meet.meeting.entity;


import javax.persistence.*;

@Entity
@Table(name = "room_list", schema = "public")
public class Room_list {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_generator")
    @SequenceGenerator(name = "room_generator", sequenceName = "roomsequence", allocationSize = 1)
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "room_location")
    private String roomLocation;
    @Column(name = "allocation_size")
    private Integer roomSize;


    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }
}
