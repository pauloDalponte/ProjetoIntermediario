package com.paulo.PauloWeather.models;

import java.util.List;

public class WeatherReturnApi {     //tratamento do retorno da api devido forma de retorno da mesma
    private int count;
    private List<Weather> data;

    public int getCount(){
        return count;
    }
    
    public void setCount(int count){
        this.count = count;
    }

    public List<Weather> getData(){
        return data;
    }

    public void setData(List<Weather> data){
        this.data = data;
    }
}
