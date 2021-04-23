package com.example.weather.api

import com.example.weather.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TheWeatherApi {

    @GET("data/2.5/weather?q=@{path}&appid=e027b761b1544c85d7a22ebe651682ac")
    suspend fun getWeather(@Path("city") city: String): Response<WeatherData>
}