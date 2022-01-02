package com.rezapour.cazootask.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rezapour.cazootask.R
import com.rezapour.cazootask.databinding.FragmentSplashScreanBinding

class SplashScreanFragment : Fragment() {

    private var _binding: FragmentSplashScreanBinding? = null
    private val binding get() = _binding!!
    private var navControler: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashScreanBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navControler = Navigation.findNavController(view)
        nextFragment()
    }

    //todo
    private fun nextFragment() {
        Handler().postDelayed({
            navControler!!.navigate(R.id.action_splashScreanFragment_to_carListFragment)
        }, 2000)
    }

}