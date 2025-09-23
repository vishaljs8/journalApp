package com.vishalsingh.journalApp.Api.responce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponce {
    private Current current;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {
        private int temperature;

        @JsonProperty("feelslike")
        private int feelslike;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;
    }
}
