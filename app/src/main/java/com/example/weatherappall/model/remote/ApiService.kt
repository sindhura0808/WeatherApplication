package com.example.weatherappall.model.remote

import com.example.weatherappall.model.remote.Constants.API_KEY
import com.example.weatherappall.model.remote.Constants.UNITS
import com.example.weatherappall.model.remote.data.currentlocationweather.CurrentLocationWeatherResponse
import com.example.weatherappall.model.remote.data.forecast.ForecastResponse
import com.example.weatherappall.model.remote.data.pollutionforecast.PollutionForecastResponse
import com.example.weatherappall.model.remote.data.weather.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") appid: String = API_KEY,
        @Query("units") units: String = UNITS
    ): Response<WeatherResponse>

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") appid: String = API_KEY,
        @Query("units") units: String = UNITS
    ): Response<ForecastResponse>

    @GET("air_pollution/forecast")
    suspend fun getPollutionForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = API_KEY,
    ): Response<PollutionForecastResponse>

//    @GET("forecast")
//    suspend fun getForecast(
//        @Query("lat") lat: Double,
//        @Query("lon") lon: Double,
//        @Query("appid") appid: String = API_KEY,
//        @Query("units") units: String = UNITS
//    ): Response<ForecastResponse>

    @GET("weather")
    suspend fun getCurrentLocationWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = API_KEY,
        @Query("units") units: String = UNITS
    ): Response<CurrentLocationWeatherResponse>
}