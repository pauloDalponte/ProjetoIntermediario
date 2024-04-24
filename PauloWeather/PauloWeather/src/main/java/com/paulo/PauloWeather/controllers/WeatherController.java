package com.paulo.PauloWeather.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.PauloWeather.models.Solicitacao;
import com.paulo.PauloWeather.models.Weather;
import com.paulo.PauloWeather.services.ConverteInfo;

@RestController
public class WeatherController{
    @Autowired
    private ConverteInfo converteInfo;
    private ArrayList<Weather> listWeathers = new ArrayList<>();

    @GetMapping("/ajuda")
    public ResponseEntity<Object> help(){
        String student = "Paulo Cesar Dal Ponte";
        String project = "PauloWeather";
        String mensage = "{ "
                            + "\"estudante\": \"" + student + "\", "
                            + "\"projeto\": \"" + project + "\""
                            + " }";
        return ResponseEntity.status(200).body(mensage);
    } 

    @GetMapping("/consulta")
    public ResponseEntity<Object> previsao(){
        return ResponseEntity.status(200).body(listWeathers);
    }

    @PostMapping("/consulta")
    public ResponseEntity<Object> previsao(@RequestBody Solicitacao solicitacao){
        Weather local = converteInfo.converteInfo(solicitacao.getLocalidade()
        );
          
        listWeathers.add(local);

        String AvisoPrevisao ="Na cidade de "+local.getCidade()+" , estará com uma temperatura em "+local.getTemperatura()
                                +" Graus Celsius, Umidade Relatica do ar na casa dos "
                                +local.getUmidadeAr()+" Metros Cubicos ,e com ventos a uma velocidade de "
                                +local.getVelocidadeVento()+" m/s."; 

        return ResponseEntity.status(200).body(AvisoPrevisao);
    }
}
