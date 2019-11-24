package com.schedule.meet.meeting.repository;

import com.schedule.meet.meeting.entity.Role_list;
import com.schedule.meet.meeting.entity.Room_list;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository<P> extends CrudRepository<Role_list, Long> {

}
