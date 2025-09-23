package com.vishalsingh.journalApp.controller;

import com.vishalsingh.journalApp.entity.UserEntry;
import com.vishalsingh.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService UserService;

    @PutMapping("/edit")
    public ResponseEntity<?> updateUser(@RequestBody UserEntry user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserEntry userdb = UserService.findByUsername(username);
        if (userdb == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found hh: " + username);
        }

        userdb.setPassword(user.getPassword());
        userdb.setUsername(user.getUsername());

         UserService.saveNew(userdb);
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @DeleteMapping("/delet")
    public boolean deletUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
       return UserService.deletUser(username);
    }


}

