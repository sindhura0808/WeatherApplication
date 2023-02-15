package com.example.weatherappall.model.remote.data.currentlocationweather

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)