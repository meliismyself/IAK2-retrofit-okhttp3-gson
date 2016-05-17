package com.meliismyself.cobakejar2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.meliismyself.cobakejar2.api.request.WeatherRequest;
import com.meliismyself.cobakejar2.api.response.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WeatherRequest.OnWeatherRequestListener{

    @BindView(R.id.tv_city)
    TextView tvCity;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.tv_humidity)
    TextView tvHumidity;

    @BindView(R.id.tv_main)
    TextView tvMain;

    @BindView(R.id.tv_temp)
    TextView tvTemp;

    private ProgressDialog progressDialog;
    private WeatherRequest mWeatherRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mWeatherRequest = new WeatherRequest(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Harap Tunggu... ");
        progressDialog.show();

        String city = "London,uk";
        mWeatherRequest.callApi(city);
    }

    @Override
    public void onRequestWeatherSuccess(Weather weatherResponse) {
        progressDialog.dismiss();
        tvCity.setText(weatherResponse.getCity());
        tvDescription.setText(weatherResponse.getListWeather().get(0).getDescription());
        double degree = weatherResponse.getWeatherMain().getTempt() - 271;
        tvTemp.setText(degree+ " C");
        tvHumidity.setText(weatherResponse.getWeatherMain().getHumidity() + "");
        tvMain.setText(weatherResponse.getListWeather().get(0).getName());
    }

    @Override
    public void onRequestWeatherFailure(String message) {
        progressDialog.dismiss();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
