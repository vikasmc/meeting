//package com.schedule.meet.meeting.controller;
//
//import java.util.Arrays;
//import java.util.Objects;
//
//import com.schedule.meet.meeting.entity.User;
//import com.schedule.meet.meeting.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.schedule.meet.meeting.security.JwtTokenUtil;
//import com.schedule.meet.meeting.domain.JwtRequest;
//import com.schedule.meet.meeting.domain.JwtResponse;
//@RestController
//@CrossOrigin
//public class JwtAuthenticationController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//    @Autowired
//    private UserService userDetailsService;
//    @RequestMapping(value = "/validate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
////        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//        final User userDetails = userDetailsService
//                .findByNameAndPass(authenticationRequest.getUsername(),authenticationRequest.getPassword()).get(0);
//        final String token = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
////    private void authenticate(String username, String password) throws Exception {
////        try {
////            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
////        } catch (DisabledException e) {
////            throw new Exception("USER_DISABLED", e);
////        } catch (BadCredentialsException e) {
////            throw new Exception("INVALID_CREDENTIALS", e);
////        }
////    }
//
//
//}