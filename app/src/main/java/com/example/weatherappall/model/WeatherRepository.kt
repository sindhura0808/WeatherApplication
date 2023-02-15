package com.example.weatherappall.model

import com.example.weatherappall.model.remote.ApiService
import com.example.weatherappall.model.remote.data.currentlocationweather.CurrentLocationWeatherResponse
import com.example.weatherappall.model.remote.data.forecast.ForecastResponse
import com.example.weatherappall.model.remote.data.pollutionforecast.PollutionForecastResponse
import com.example.weatherappall.model.remote.data.weather.WeatherResponse
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository@Inject constructor(private val apiService: ApiService):Repository {

    override suspend fun getCurrentWeather(city: String): Response<WeatherResponse> {
        return apiService.getWeather(city)
    }

    override suspend fun getWeatherForecast(city: String): Response<ForecastResponse> {
        return apiService.getForecast(city)
    }

    override suspend fun getCurrentLocationWeather(
        lat: Double,
        lon: Double
    ): Response<CurrentLocationWeatherResponse> {
        return apiService.getCurrentLocationWeather(lat, lon)
    }

    override suspend fun getPollutionForecast(
        lat: Double,
        lon: Double
    ): Response<PollutionForecastResponse> {
        return  apiService.getPollutionForecast(lat, lon)
    }
}