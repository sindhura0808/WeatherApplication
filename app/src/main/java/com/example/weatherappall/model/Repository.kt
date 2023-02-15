package com.example.weatherappall.model

import com.example.weatherappall.model.remote.data.currentlocationweather.CurrentLocationWeatherResponse
import com.example.weatherappall.model.remote.data.forecast.ForecastResponse
import com.example.weatherappall.model.remote.data.pollutionforecast.PollutionForecastResponse
import com.example.weatherappall.model.remote.data.weather.WeatherResponse
import retrofit2.Response

interface Repository {

    suspend fun getCurrentWeather(city: String): Response<WeatherResponse>
    suspend fun getWeatherForecast(city: String): Response<ForecastResponse>
    suspend fun getCurrentLocationWeather(lat: Double, lon: Double): Response<CurrentLocationWeatherResponse>
    suspend fun getPollutionForecast(lat: Double, lon: Double): Response<PollutionForecastResponse>
}