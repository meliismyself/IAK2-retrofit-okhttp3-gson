package com.meliismyself.cobakejar2.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Meli Oktavia on 4/30/2016.
 */
public class APIService {
    public static String API_KEY = "23cb33555c6e6d90e8f4a3908242ea64";
    public static String BASE_URL = "http://api.openweathermap.org/";
    public static String BASE_PATH = "/data/2.5";

    public static <S> S createService (Class<S> serviceClass){
        final OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
       /* okHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json").build();
                return chain.proceed(request);
            }
        });*/

        Gson gson = new GsonBuilder()
                .create();

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return builder.create(serviceClass);
    }

}
