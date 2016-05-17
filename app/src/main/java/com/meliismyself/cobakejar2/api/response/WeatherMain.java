package com.meliismyself.cobakejar2.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Meli Oktavia on 4/30/2016.
 */
public class WeatherMain {
    @SerializedName("temp")
    private double tempt;

    @SerializedName("pressure")
    private double preassure;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("temp_min")
    private double tempMin;

    @SerializedName("temp_max")
    private double tempMax;

    public double getTempt() {
        return tempt;
    }

    public void setTempt(double tempt) {
        this.tempt = tempt;
    }

    public double getPreassure() {
        return preassure;
    }

    public void setPreassure(double preassure) {
        this.preassure = preassure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }
}
