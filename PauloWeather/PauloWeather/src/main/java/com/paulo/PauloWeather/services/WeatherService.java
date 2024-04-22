package com.paulo.PauloWeather.services;

import org.springframework.stereotype.Service;
import com.paulo.PauloWeather.models.Weather;
import com.paulo.PauloWeather.models.WeatherReturnApi;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService implements ConverteInfo {

    private static final String apiUrl = "https://api.weatherbit.io/v2.0/current";
    private static final String apiKey = "6cb6e56024604dd98f02d2f24d0f9403";

    private final WebClient webClient;

    public WeatherService() {
        this.webClient = WebClient.create(apiUrl);
    }

    @Override
    public Weather converteInfo(String cep) {
        Mono<WeatherReturnApi> result = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .queryParam("postal_code", cep)
                .queryParam("key", apiKey)
                .build())
            .retrieve()
            .bodyToMono(WeatherReturnApi.class);

            Weather weather = result.map(response -> response.getData().get(0)).block();  

            return weather;
    }
}
