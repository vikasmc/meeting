package com.schedule.meet.meeting.controller;

import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users/authenticate", method = RequestMethod.POST)
    public ResponseEntity<User> getPersoneByName(@RequestBody com.schedule.meet.meeting.domain.User user) {
         User curUser = userService.findByNameAndPass(user.getUserName(), user.getPassword()).get(0);
        return ResponseEntity.ok(curUser);
    }


    @RequestMapping(value = "/users/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crateUser(@RequestBody com.schedule.meet.meeting.domain.User user) {
        User newUser = new User();
        newUser.setCreatedOn(LocalDateTime.now());
        newUser.setLastLoginTime(LocalDateTime.now());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        try{
            userService.addPerson(newUser);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
