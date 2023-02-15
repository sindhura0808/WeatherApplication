package com.example.weatherappall.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappall.model.WeatherRepository
import com.example.weatherappall.model.remote.data.currentlocationweather.CurrentLocationWeatherResponse
import com.example.weatherappall.model.remote.data.forecast.ForecastResponse
import com.example.weatherappall.model.remote.data.pollutionforecast.PollutionForecastResponse
import com.example.weatherappall.model.remote.data.weather.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository) :
    ViewModel() {

    val weatherLiveData = MutableLiveData<WeatherResponse>()
    val forecastLiveData = MutableLiveData<ForecastResponse>()
    val currentLocationWeatherLiveData = MutableLiveData<CurrentLocationWeatherResponse>()
    val pollutionForecastLiveData = MutableLiveData<PollutionForecastResponse>()
    val error = MutableLiveData<String>()

    fun getCurrentWeather(city: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getCurrentWeather(city)

            if (!response.isSuccessful) {
                error.postValue("Failed to load data!")
            } else {
                weatherLiveData.postValue(response.body())
            }
        } catch (e: Exception) {
            error.postValue("Error message: $e")
            e.printStackTrace()
        }
    }

    fun getWeatherForecast(city: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = repository.getWeatherForecast(city)

            if (!response.isSuccessful) {
                error.postValue("Failed to load data!")
            } else {
                forecastLiveData.postValue(response.body())
            }
        } catch (e: Exception) {
            error.postValue("Error message: $e")
            e.printStackTrace()
        }
    }

    fun getCurrentLocationWeather(lat: Double, lon: Double) =
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.e("...","ZZZZ")
                val response = repository.getCurrentLocationWeather(lat, lon)

                if (!response.isSuccessful){
                    error.postValue("Failed to load data!")
                }else{
                    currentLocationWeatherLiveData.postValue(response.body())
                }
            } catch (e: Exception){
                error.postValue("Error message: $e")
                e.printStackTrace()
            }
        }

    fun getPollutionForecast(lat: Double, lon: Double) =
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val response = repository.getPollutionForecast(lat, lon)

                if (!response.isSuccessful){
                    error.postValue("Failed to load data!")
                }else{
                    pollutionForecastLiveData.postValue(response.body())
                }
            } catch (e: Exception){
                error.postValue("Error message: $e")
                e.printStackTrace()
            }
        }
}
