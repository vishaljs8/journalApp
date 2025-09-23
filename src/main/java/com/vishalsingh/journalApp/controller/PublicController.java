package com.vishalsingh.journalApp.controller;

import com.vishalsingh.journalApp.Api.responce.WeatherResponce;
import com.vishalsingh.journalApp.entity.UserEntry;
import com.vishalsingh.journalApp.service.UserService;
import com.vishalsingh.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    public UserService UserService;

    @Autowired
    public WeatherService weatherService;

    @PostMapping("/create_user")
    public boolean saveEntry(@RequestBody UserEntry entry){
       return UserService.saveNew(entry);
    }

    @GetMapping
    public ResponseEntity<?> greetings() {
        String greeting = " ";
        WeatherResponce responce = weatherService.weatherInfo("Aligarh");
        System.out.println(responce);

        if (responce != null && responce.getCurrent() != null) {
            greeting = " weather feels like: " + responce.getCurrent().getTemperature();
        } else {
            greeting = " weather data not available";
        }
        return new ResponseEntity<>("Hii :) "  + greeting, HttpStatus.OK);
    }

}
