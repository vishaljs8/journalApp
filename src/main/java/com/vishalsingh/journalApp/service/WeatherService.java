package com.vishalsingh.journalApp.service;

import com.vishalsingh.journalApp.Api.responce.WeatherResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    //@Value("${weather.api.key}")
    private String APIkey = "40dd214b4bbe60c32b311dec6a4eaafc";

    private static final String API ="https://api.weatherstack.com/current?access_key={key}&query={CITY}";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponce weatherInfo(String city) {
        String url = API.replace("{key}", APIkey).replace("{CITY}", city);
        System.out.println("Requesting URL: " + url);

        try {
            ResponseEntity<String> raw = restTemplate.getForEntity(url, String.class);
            System.out.println("Raw JSON Response: " + raw.getBody());

            ResponseEntity<WeatherResponce> response =
                    restTemplate.getForEntity(url, WeatherResponce.class);

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}