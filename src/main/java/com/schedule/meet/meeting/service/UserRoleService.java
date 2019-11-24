package com.schedule.meet.meeting.service;

import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.entity.User_roles;
import com.schedule.meet.meeting.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository<User_roles> user_rolesUserRoleRepository;

    @Transactional
    public List<User_roles> getAllUserRole() {
        return (List<User_roles>) user_rolesUserRoleRepository.findAll();
    }

    @Transactional
    public User_roles getUserRoleByUser(Long userId){
        List<User_roles> roleByUserId = user_rolesUserRoleRepository.findRoleByUserId(userId);
        if(roleByUserId.size()==0){
            return null;
        }
        return roleByUserId.get(0);
    }




    @Transactional
    public User_roles getById(Long roleId) {
        return user_rolesUserRoleRepository.findById(roleId).get();
    }

    @Transactional
    public boolean addUserRole(User_roles role_list) {
        return user_rolesUserRoleRepository.save(role_list) != null;
    }

    @Transactional
    public boolean updateUserRole(User_roles role_list) {
        return user_rolesUserRoleRepository.save(role_list) != null;
    }

}
