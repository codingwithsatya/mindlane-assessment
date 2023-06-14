package com.weatherapp.weather.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.google.gson.Gson;
// import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherApiController {

    @GetMapping("/getTemp")
    public String getTemperatureByCities(@RequestParam List<String> cities) throws IOException {
        String apiKey = "22c17a157d9303226dcaa25d2797cd46";
        List<String> weatherDataList = new ArrayList<>();

        for (String city : cities) {
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey
                    + "&units=metric";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            weatherDataList.add(response.toString());
        }

        return weatherDataList.toString();
    }
}
