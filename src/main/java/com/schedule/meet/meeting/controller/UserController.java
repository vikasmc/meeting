package com.schedule.meet.meeting.controller;

import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.service.UserService;
import com.schedule.meet.meeting.token.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/users/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> getPersoneByName(@RequestBody com.schedule.meet.meeting.domain.User user) {
         User curUser = userService.findByNameAndPass(user.getUserName(), user.getPassword()).get(0);
        if (curUser != null) {
            final String token = jwtTokenUtil.generateToken(user);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
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
