package com.example.weatherappall.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.weatherappall.R
import com.example.weatherappall.databinding.FragmentBottomSheetLayoutBinding
import com.example.weatherappall.viewmodel.WeatherViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar


class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetLayoutBinding
    private lateinit var viewModel: WeatherViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBottomSheetLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[WeatherViewModel::class.java]

        binding.btnSearch.setOnClickListener {
            if (!binding.edtCity.text.isNullOrEmpty()) {
                viewModel.getCurrentWeather(binding.edtCity.text.toString())
                viewModel.getWeatherForecast(binding.edtCity.text.toString())
                (activity as MainActivity).setRangeViewEnabled(true)
                (activity as MainActivity).setViewCallByFragment(true)
                dismiss()
            } else {
                dialog?.window?.let { it ->
                   val snack = Snackbar.make(
                        it.decorView,
                        "Please enter an valid city name!",
                        Snackbar.LENGTH_LONG
                    )
                    snack.anchorView = binding.root
                    snack.setAction("DISMISS"){}
                    snack.show()
                }
            }
        }
    }

    companion object {

        const val TAG = "CustomBottomSheetDialogFragment"

    }
}