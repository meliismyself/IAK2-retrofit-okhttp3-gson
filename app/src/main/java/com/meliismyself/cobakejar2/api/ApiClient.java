package com.meliismyself.cobakejar2.api;

import com.meliismyself.cobakejar2.api.response.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Meli Oktavia on 4/30/2016.
 */
public interface ApiClient {
    @GET("/data/2.5/weather")
    Call<Weather> getWeather(@Query("q") String q,
                             @Query("appid") String appId);
}
