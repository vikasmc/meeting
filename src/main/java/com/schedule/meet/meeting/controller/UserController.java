package com.schedule.meet.meeting.controller;

import com.schedule.meet.meeting.entity.Role_list;
import com.schedule.meet.meeting.entity.User;
import com.schedule.meet.meeting.entity.User_roles;
//import com.schedule.meet.meeting.security.JwtTokenUtil;
import com.schedule.meet.meeting.service.RoleService;
import com.schedule.meet.meeting.service.UserRoleService;
import com.schedule.meet.meeting.service.UserService;
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
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;


    @RequestMapping(value = "/users/authenticate", method = RequestMethod.POST)
    public ResponseEntity<User> getPersoneByName(@RequestBody com.schedule.meet.meeting.domain.User user) {
         List<User> curUsers = userService.findByNameAndPass(user.getUserName(), user.getPassword());
         if(curUsers.size()!=0){
             User curUser = curUsers.get(0);
//             final String token = jwtTokenUtil.generateToken(curUser);
             User_roles userRoleByUser = userRoleService.getUserRoleByUser(curUser.getUserId());
             if(userRoleByUser==null){
                 return ResponseEntity.notFound().build();
             }
             Role_list byId = roleService.getById(userRoleByUser.getRole_id());
             curUser.setType(byId.getRoleName());
//             curUser.setToken(token);
             return ResponseEntity.ok(curUser);
         }else{
             return ResponseEntity.notFound().build();
         }
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
            User userList = userService.findByName(newUser.getUserName()).get(0);
            Role_list byId = roleService.getById(2l);
            User_roles user_roles = new User_roles();
            user_roles.setUserId(userList.getUserId());
            user_roles.setRole_id(byId.getRoleId());
            userRoleService.addUserRole(user_roles);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
