package com.paulo.PauloWeather.models;

public class Weather {
    private double temp;
    private String city_name;
    private double rh;
    private double wind_spd;
    private String datetime;

    public Weather( double temp,String city_name, double rh, double wind_spd, String datetime ){
        this.temp = temp;
        this.city_name = city_name;
        this.rh = rh;
        this.wind_spd = wind_spd;
        this.datetime =datetime;
    }

    public double getTemperatura() {
        return temp;
    }

    public void setTemperatura(double temp) {
        this.temp = temp;
    }

    public String getCidade() {
        return city_name;
    }

    public void setCidade(String city_name) {
        this.city_name = city_name;
    }

    public double getUmidadeAr() {
        return rh;
    }

    public void setUmidadeAr(double rh) {
        this.rh = rh;
    }

    public double getVelocidadeVento() {
        return wind_spd;
    }

    public void setVelocidadeVento(double wind_spd) {
        this.wind_spd  = wind_spd;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
