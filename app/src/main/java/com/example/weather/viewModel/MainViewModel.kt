package com.example.weather.viewModel

import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.model.WeatherData
import com.example.weather.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<WeatherData> = MutableLiveData()

    fun getWeather(cityEditText: EditText) {
        viewModelScope.launch {
            val city = cityEditText.text.toString()
            val response = repository.getWeather(city)
            if (response.isSuccessful && response.body() != null) {
                myResponse.value = response.body()
            }
        }
    }

}




















