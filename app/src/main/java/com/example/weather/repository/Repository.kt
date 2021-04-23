package com.example.weather.repository

import com.example.weather.api.RetrofitInstance
import com.example.weather.model.WeatherData
import retrofit2.Response

class Repository {

    private val theWeatherApi = RetrofitInstance.theWeatherApi

    suspend fun getWeather(city: String): Response<WeatherData> {
        return theWeatherApi.getWeather(city)
    }
}