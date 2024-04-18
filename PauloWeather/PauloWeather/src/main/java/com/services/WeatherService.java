package com.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {
    private RestClient client = RestClient.create("https://api.weatherbit.io/v2.0/current?postal_code=");

    public Weather{
    return client
            .get()
            .uri("{cep}&key=6cb6e56024604dd98f02d2f24d0f9403",cep)
            .retrieve()
            .body(Weather.class);
    }
}
