package com.paulo.PauloWeather.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.PauloWeather.models.Weather;

@RestController
public class WeatherController {
    @Autowired
    private ArrayList<Weather> listWeathers = new ArrayList<>();

    @GetMapping("/ajuda")
    public ResponseEntity<Object> help() {
        String student = "paulo";
        String project = "teste";
        String mensage = "Nome: " + student + ", Proje: " + project;
        return ResponseEntity.status(200).body(mensage);
    } 
}
