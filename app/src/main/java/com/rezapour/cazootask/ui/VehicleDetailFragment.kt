package com.rezapour.cazootask.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rezapour.cazootask.R
import com.rezapour.cazootask.databinding.FragmentVehicleDetailBinding
import com.rezapour.cazootask.util.DataState
import com.rezapour.cazootask.viewmodel.VehicleDetatilViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleDetailFragment : Fragment() {

    val viewModel: VehicleDetatilViewModel by viewModels()

    var _binding: FragmentVehicleDetailBinding? = null
    val binding get() = _binding!!
    val TAG = "Test rezaPour"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVehicleDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        subscribeToViewModel()
        viewModel.getVehicleDetail("4f05d76c-ae89-51fa-9965-c156b6c8f452")
    }

    private fun subscribeToViewModel() {
        viewModel.dataState.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success -> Log.d(TAG, "Success ${dataState.data.model}")
                is DataState.Error -> Log.d(TAG, "Error=${dataState.message}")
                is DataState.Loading -> Log.d(TAG, "Loading")

            }

        }
    }


}