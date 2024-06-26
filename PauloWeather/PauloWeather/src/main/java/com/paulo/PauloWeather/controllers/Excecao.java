package com.paulo.PauloWeather.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Excecao{
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuResponseEntity(RuntimeException ex){

        return ResponseEntity
            .status(HttpStatus.SERVICE_UNAVAILABLE)
            .body(ex.getMessage());
    }
}
