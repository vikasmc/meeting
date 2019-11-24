package com.schedule.meet.meeting.service;

import com.schedule.meet.meeting.entity.Role_list;
import com.schedule.meet.meeting.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository<Role_list> RoleRepository;

    @Transactional
    public List<Role_list> getAllRole() {
        return (List<Role_list>) RoleRepository.findAll();
    }


    @Transactional
    public Role_list getById(Long roleId) {
        return RoleRepository.findById(roleId).get();
    }

    @Transactional
    public boolean addRole(Role_list role_list) {
        return RoleRepository.save(role_list) != null;
    }

    @Transactional
    public boolean updateRole(Role_list role_list) {
        return RoleRepository.save(role_list) != null;
    }

}
