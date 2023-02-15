package com.example.weatherappall.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappall.R
import com.example.weatherappall.databinding.ViewCurrentBinding
import com.example.weatherappall.model.remote.data.forecast.WeatherDecorator
import com.example.weatherappall.model.remote.data.forecast.WeatherDetail

class CurrentAdapter(private val weather: List<WeatherDetail>) :
    RecyclerView.Adapter<CurrentAdapter.WeatherViewHolder>() {

    override fun getItemCount(): Int {
        return weather.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewCurrentBinding>(
            layoutInflater,
            R.layout.view_current,
            parent,
            false
        )
        val layoutParams: ViewGroup.LayoutParams = binding.root.layoutParams
        layoutParams.width = (parent.width * 0.31).toInt()
        binding.root.layoutParams = layoutParams
        return WeatherViewHolder(binding)
    }


    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.setData(weather[position])
    }

    inner class WeatherViewHolder(private val binding: ViewCurrentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(weather: WeatherDetail) {
            binding.weather = WeatherDecorator.decorate(weatherDetail = weather)
        }
    }
}