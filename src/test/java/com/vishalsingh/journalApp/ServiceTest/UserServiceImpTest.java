package com.vishalsingh.journalApp.ServiceTest;

import com.vishalsingh.journalApp.entity.UserEntry;
import com.vishalsingh.journalApp.repository.UserRepository;
import com.vishalsingh.journalApp.service.UserDetailServiceIMP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.mockito.Mockito.when;
@Disabled
@SpringBootTest
public class UserServiceImpTest {

    @InjectMocks
    private UserDetailServiceIMP userDetailServiceIMP;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void mock(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void  loaduserTest(){
        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(Optional.ofNullable(UserEntry.builder().username("gun").password("gun").roles(new ArrayList<>()).build()));
        Assertions.assertTrue((BooleanSupplier) userDetailServiceIMP.loadUserByUsername("gun"));
    }
}
