package com.schedule.meet.meeting.service;

import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository<User> userRepository;

    @Transactional
    public List<User> getAllPersons() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    public List<User> findByName(String name) {
        return userRepository.findByUserName(name);
    }

    @Transactional
    public List<User> findByNameAndPass(String name, String pass) {
        return userRepository.findByUserNameAndPassword(name,pass);
    }

    @Transactional
    public User getById(Long id) {
        return (User) userRepository.findById(id).get();
    }

    @Transactional
    public boolean addPerson(User person) {
        return userRepository.save(person) != null;
    }

    @Transactional
    public boolean updatePerson(User person) {
        return userRepository.save(person) != null;
    }

}
