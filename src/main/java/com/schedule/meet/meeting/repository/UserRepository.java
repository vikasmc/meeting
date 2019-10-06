package com.schedule.meet.meeting.repository;

import com.schedule.meet.meeting.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository<P> extends CrudRepository<User, Long> {


    List<User> findByUserName(String username);
    List<User> findByUserNameAndPassword(String username,String password);
}
