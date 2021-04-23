package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.weather.repository.Repository
import com.example.weather.viewModel.MainViewModel
import com.example.weather.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val cityEditText: EditText by lazy { findViewById(R.id.city_edit_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = viewModelFactory.create(MainViewModel::class.java)

        viewModel.getWeather(cityEditText)
        viewModel.myResponse.observe(this) {
            findViewById<TextView>(R.id.weather_info_text).text = it.weather[0].main
        }
    }
}