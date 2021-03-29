package com.tts.weatherapp.service;

import java.util.List;

import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.ZipCode;
import com.tts.weatherapp.repository.RequestRepository;
import com.tts.weatherapp.repository.ZipCodeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



@Service
public class WeatherService {
    
    @Value("${api_key}")
    private String apiKey;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ZipCodeRepo zipCodeRepo;

    public List<ZipCode> getRecentSearces(){
        return zipCodeRepo.findAll();
    }

    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
            zipCode + "&units=metric&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        ZipCode zip=new ZipCode(zipCode);
        zipCodeRepo.save(zip);
        try {
            return restTemplate.getForObject(url, Response.class);
             
            } catch (HttpClientErrorException ex) {
                Response response = new Response();
                response.setName("error");
                return response; 
            }
    }

}
