package com.meliismyself.cobakejar2.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Meli Oktavia on 4/30/2016.
 */
public class Weather {
    @SerializedName("main")
    private WeatherMain weatherMain;

    @SerializedName("weather")
    private ArrayList<WeatherItem> listWeather = new ArrayList<>();

    @SerializedName("name")
    private String city;

    public WeatherMain getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(WeatherMain weatherMain) {
        this.weatherMain = weatherMain;
    }

    public ArrayList<WeatherItem> getListWeather() {
        return listWeather;
    }

    public void setListWeather(ArrayList<WeatherItem> listWeather) {
        this.listWeather = listWeather;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
