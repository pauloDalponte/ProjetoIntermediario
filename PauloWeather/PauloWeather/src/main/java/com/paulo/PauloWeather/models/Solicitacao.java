package com.paulo.PauloWeather.models;

public class Solicitacao {
    private String localidade;

    public Solicitacao() {
    }

    public Solicitacao(String localidade){
        this.localidade = localidade;
    }

    public String getLocalidade(){
        return localidade;
    }

    public void setLocalidade(String localidade){
        this.localidade = localidade;
    }
}
