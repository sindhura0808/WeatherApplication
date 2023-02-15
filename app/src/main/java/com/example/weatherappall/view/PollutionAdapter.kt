package com.example.weatherappall.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappall.R
import com.example.weatherappall.databinding.ItemPollutionBinding
import com.example.weatherappall.model.remote.data.pollutionforecast.Pollution
import kotlinx.coroutines.NonDisposableHandle.parent

class PollutionAdapter(private val pollution: List<Pollution>) :
    RecyclerView.Adapter<PollutionAdapter.PollutionViewHolder>() {

    override fun getItemCount(): Int {
        return pollution.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PollutionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPollutionBinding>(
            layoutInflater,
            R.layout.item_pollution,
            parent,
            false
        )
        return PollutionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PollutionViewHolder, position: Int) {
        holder.setData(pollution[position])
    }

    inner class PollutionViewHolder(private val binding: ItemPollutionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun setData(pollution: Pollution) {
            binding.pollution = pollution
            pollution.components.no2.toInt().let { no2 ->
                binding.tvNo2.let { textView ->
                    when (no2) {
                        in 1..50 -> textView.setTextColor(Color.parseColor("#118A3D"))
                        in 51..100 -> textView.setTextColor(Color.parseColor("#A4C639"))
                        in 101..200 -> textView.setTextColor(Color.parseColor("#E5F322"))
                        in 201..400 -> textView.setTextColor(Color.parseColor("#DF967E"))
                        in 401..Int.MAX_VALUE -> textView.setTextColor(Color.parseColor("#ff0000"))
                    }
                }
            }

            pollution.components.pm10.toInt().let { pm10 ->
                binding.tvPm10.let { textView ->
                    when (pm10) {
                        in 0..25 -> textView.setTextColor(Color.parseColor("#118A3D"))
                        in 26..50 -> textView.setTextColor(Color.parseColor("#A4C639"))
                        in 51..90 -> textView.setTextColor(Color.parseColor("#E5F322"))
                        in 91..180 -> textView.setTextColor(Color.parseColor("#DF967E"))
                        in 181..Int.MAX_VALUE -> textView.setTextColor(Color.parseColor("#ff0000"))
                    }
                }
            }

            pollution.components.o3.toInt().let { o3 ->
                binding.tvO3.let { textView ->
                    when (o3) {
                        in 1..60 -> textView.setTextColor(Color.parseColor("#118A3D"))
                        in 61..120 -> textView.setTextColor(Color.parseColor("#A4C639"))
                        in 121..180 -> textView.setTextColor(Color.parseColor("#E5F322"))
                        in 181..240 -> textView.setTextColor(Color.parseColor("#DF967E"))
                        in 241..Int.MAX_VALUE -> textView.setTextColor(Color.parseColor("#ff0000"))
                    }
                }
            }

            pollution.components.pm2_5.toInt().let { pm2_5 ->
                binding.tvPm25.let { textView ->
                    when (pm2_5) {
                        in 1..15 -> textView.setTextColor(Color.parseColor("#118A3D"))
                        in 16..30 -> textView.setTextColor(Color.parseColor("#A4C639"))
                        in 31..55 -> textView.setTextColor(Color.parseColor("#E5F322"))
                        in 56..110 -> textView.setTextColor(Color.parseColor("#DF967E"))
                        in 111..Int.MAX_VALUE -> textView.setTextColor(Color.parseColor("#ff0000"))
                    }
                }
            }
        }
    }
}
