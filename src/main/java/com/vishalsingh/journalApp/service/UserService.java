package com.vishalsingh.journalApp.service;

import com.vishalsingh.journalApp.entity.UserEntry;
import com.vishalsingh.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Slf4j
@Component
public class UserService{

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public  List<UserEntry> getAll() {

        return userRepository.findAll();
    }

    public boolean saveNew(UserEntry entry){
        try{
            entry.setPassword(passwordEncoder.encode(entry.getPassword()));
            entry.setRoles(Arrays.asList("USER"));
            userRepository.save(entry);
            return true;
        }catch (Exception e){
            log.info("already exist user");
            return false;
        }


    }

    public UserEntry save(UserEntry entry){

        return userRepository.save(entry);
    }

    public UserEntry findByUsername(String username) {

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public boolean deletUser(String username){
        UserEntry user= userRepository.findByUsername(username).orElse(null);
        if(user!=null){
        userRepository.delete(user);
        return true;
        }
        return false;
    }
}
