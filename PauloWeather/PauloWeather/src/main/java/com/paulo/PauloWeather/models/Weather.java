package com.paulo.PauloWeather.models;

public class Weather {
    private double temperatura;
    private String cidade;
    private double umidadeAr;
    private double velocidadeVento;
    private String datetime;

    public Weather( double temperatura,String cidade, double umidadeAr, double velocidadeVento, String datetime ){
        this.temperatura = temperatura;
        this.cidade = cidade;
        this.umidadeAr = umidadeAr;
        this.velocidadeVento = velocidadeVento;
        this.datetime =datetime;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temp) {
        this.temperatura = temp;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String city_name) {
        this.cidade = city_name;
    }

    public double getUmidadeAr() {
        return umidadeAr;
    }

    public void setUmidadeAr(double rh) {
        this.umidadeAr = rh;
    }

    public double getWind_spd() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(double wind_spd) {
        this.velocidadeVento  = wind_spd;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
