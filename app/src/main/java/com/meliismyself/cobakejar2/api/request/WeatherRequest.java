package com.meliismyself.cobakejar2.api.request;

import com.meliismyself.cobakejar2.api.APIService;
import com.meliismyself.cobakejar2.api.ApiClient;
import com.meliismyself.cobakejar2.api.response.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Meli Oktavia on 4/30/2016.
 */
public class WeatherRequest {
    private ApiClient apiClient;
    private Call<Weather> request;
    private OnWeatherRequestListener listener;

    public WeatherRequest(OnWeatherRequestListener listener){
        apiClient = APIService.createService(ApiClient.class);
        this.listener = listener;
    }

    public void callApi(String city){
        request = apiClient.getWeather(city, APIService.API_KEY);
        request.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response != null && response.isSuccessful()){
                    Weather mWeather = response.body();
                    listener.onRequestWeatherSuccess(mWeather);
                }else {
                    listener.onRequestWeatherFailure("Response Invalid");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                String errorMessage = t.getMessage() != null?
                        t.getMessage() : "Unable to connect to server";
                listener.onRequestWeatherFailure(errorMessage);
            }
        });
    }

    public void cancelAPI(){
        if (request != null){
            request.cancel();
        }
    }
    public interface OnWeatherRequestListener{
        void onRequestWeatherSuccess(Weather weatherResponse);
        void onRequestWeatherFailure(String message);
    }
}
