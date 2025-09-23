package com.vishalsingh.journalApp.ServiceTest;

import com.vishalsingh.journalApp.entity.UserEntry;
import com.vishalsingh.journalApp.repository.UserRepository;
import com.vishalsingh.journalApp.service.UserService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
//public class UserServiceTest {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private UserService userService;
//
//
//@ParameterizedTest
//@ArgumentsSource(ArgumentProvider.class)
//    public void Testsave(UserEntry user){
//    assertTrue(userService.saveNew(user));
//}
//
//}
