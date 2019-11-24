package com.schedule.meet.meeting.domain;

import java.time.LocalDate;

public class SearchRequest {

    private String roomName;
    private String presenter;
    private LocalDate day;


    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
