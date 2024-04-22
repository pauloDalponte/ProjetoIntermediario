package com.paulo.PauloWeather.services;

import org.springframework.stereotype.Service;
import com.paulo.PauloWeather.models.Weather;
import com.paulo.PauloWeather.models.WeatherReturnApi;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService implements ConverteInfo {

    private static final String apiUrl = "https://api.weatherbit.io/v2.0/current"; //url base
    private static final String apiKey = "f3d7e0dd7b644b9a98c6aa8d32887a39"; //chave disponibilizada

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
                .queryParam("postal_code", cep) //troca o cep para uso na api
                .queryParam("key", apiKey) //insere a chave na url
                .build())
            .retrieve()
            .onStatus(httpStatus -> httpStatus.is4xxClientError(), response -> Mono.error(new RuntimeException("Erro no cliente ao acessar a API do terceiro."))) //verifica status da resposta http
            .onStatus(httpStatus -> httpStatus.is5xxServerError(), response -> Mono.error(new RuntimeException("Erro no servidor da API do terceiro.")))  //verifica status da resposta http           
            .bodyToMono(WeatherReturnApi.class)
            .map(response -> response.getData().get(0))
            .onErrorResume(e -> {
                return Mono.error(new RuntimeException("Falha ao acessa Api do Terceiro.")); //
            })
            .block(); //aguarda retorno
    }
}


