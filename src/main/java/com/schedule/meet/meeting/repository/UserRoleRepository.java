package com.schedule.meet.meeting.repository;

import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.entity.User_roles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository<P> extends CrudRepository<User_roles, Long> {



    List<User_roles> findRoleByUserId(Long userId);

}
