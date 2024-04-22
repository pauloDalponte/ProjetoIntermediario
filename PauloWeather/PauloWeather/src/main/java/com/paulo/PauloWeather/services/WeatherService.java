package com.paulo.PauloWeather.services;

import org.springframework.stereotype.Service;
import com.paulo.PauloWeather.models.Weather;
import com.paulo.PauloWeather.models.WeatherReturnApi;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

// @Service
// public class WeatherService implements ConverteInfo {

//     private static final String apiUrl = "https://api.weatherbit.io/v2.0/current";
//     private static final String apiKey = "f3d7e0dd7b644b9a98c6aa8d32887a39";

//     private final WebClient webClient;

//     public WeatherService() {
//         this.webClient = WebClient.create(apiUrl);
//     }

//     @Override
//     public Weather converteInfo(String cep) {
//         Mono<WeatherReturnApi> result = webClient.get()
//             .uri(uriBuilder -> uriBuilder
//                 .queryParam("postal_code", cep)
//                 .queryParam("key", apiKey)
//                 .build())
//             .retrieve()
//             .bodyToMono(WeatherReturnApi.class);

//             Weather weather = result.map(response -> response.getData().get(0)).block();  

//             return weather;
//     }
// }
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.paulo.PauloWeather.models.Weather;
import com.paulo.PauloWeather.models.WeatherReturnApi;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class WeatherService implements ConverteInfo {

    private static final String apiUrl = "https://api.weatherbit.io/v2.0/current";
    private static final String apiKey = "f3d7e0dd7b644b9a98c6aa8d32887a39";

    private final WebClient webClient;

    public WeatherService() {
        this.webClient = WebClient.builder()
                                  .baseUrl(apiUrl)
                                  .build();
    }

    @Override
    public Weather converteInfo(String cep) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .queryParam("postal_code", cep)
                .queryParam("key", apiKey)
                .build())
            .retrieve()
            .onStatus(status -> status.isError(), response -> Mono.error(new RuntimeException("API do terceiro está indisponível.")))
            .bodyToMono(WeatherReturnApi.class)
            .map(response -> response.getData().get(0))
            .onErrorResume(e -> {
                // Log aqui, se necessário. Adapte a logica conforme necessidade
                return Mono.error(new RuntimeException("API do terceiro está indisponível."));
            })
            .block();  // block() transforma Mono em um resultado direto, mas deve ser usado com cuidado em ambientes reativos
    }
}


