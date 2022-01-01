package com.rezapour.cazootask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rezapour.cazootask.databinding.FragmentCarListBinding
import com.rezapour.cazootask.model.CarsListDetatil
import com.rezapour.cazootask.ui.adapter.VehicleLIstAdapter
import com.rezapour.cazootask.util.DataState
import com.rezapour.cazootask.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import com.rezapour.cazootask.R
import com.rezapour.cazootask.assets.Messages


@AndroidEntryPoint
class CarListFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentCarListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VehicleLIstAdapter
    private var navController: NavController? = null
    lateinit var swiper: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        setUp()
    }

    private fun setUp() {
        initUI()
        subscribeToViewModel()
        viewModel.getCarsList()

    }

    private fun initUI() {
        recyclerView = binding.ListCarsRecyclerView
        adapter = VehicleLIstAdapter(ArrayList<CarsListDetatil>()) { id ->

            navController!!.navigate(
                CarListFragmentDirections.actionCarListFragmentToVehicleDetailFragment(
                    id
                )
            )
        }
        recyclerView.adapter = adapter

        val layoutManger = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManger

        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, layoutManger.getOrientation())
        recyclerView.addItemDecoration(dividerItemDecoration)

        swiper = binding.swiperLayout
        swiper.setOnRefreshListener {
            viewModel.getCarsList()
        }

    }

    private fun subscribeToViewModel() {
        viewModel.dataStatListOfCars.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success -> successRespond(dataState.data)
                is DataState.Error -> errorRespond(dataState.message)
                is DataState.Loading -> loading(true)
            }

        }
    }

    private fun successRespond(item: List<CarsListDetatil>) {
        loading(false)
        adapter.addItem(item)
        adapter.notifyDataSetChanged()
    }

    private fun errorRespond(message: String) {
        loading(false)

        when (message) {
            Messages.Error.INTERNET_CONNECTION_LIST -> snackBar(getString(R.string.error_internet_connection))
            Messages.Error.NO_CONTENT -> snackBar(getString(R.string.error_no_content))
            else -> snackBar(message)

        }

    }

    private fun snackBar(mes: String) {
        Snackbar.make(binding.coordinatorListVehicle, mes, Snackbar.LENGTH_LONG).show();
    }

    private fun loading(isShow: Boolean) {
        swiper.isRefreshing = isShow
    }

}