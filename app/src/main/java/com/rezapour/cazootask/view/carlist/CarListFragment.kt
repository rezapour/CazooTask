package com.rezapour.cazootask.view.carlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rezapour.cazootask.databinding.FragmentCarListBinding
import com.rezapour.cazootask.model.VehicleListDetatil
import com.rezapour.cazootask.view.adapter.VehicleLIstAdapter
import com.rezapour.cazootask.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import com.rezapour.cazootask.R
import com.rezapour.cazootask.assets.Messages


@AndroidEntryPoint
class CarListFragment : Fragment() {

    private val viewModel: VehicleListViewModel by viewModels()
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
        viewModel.getCarsData()

    }

    private fun initUI() {
        recyclerView = binding.ListCarsRecyclerView
        adapter = VehicleLIstAdapter(ArrayList<VehicleListDetatil>(), { id ->

            navController!!.navigate(
                CarListFragmentDirections.actionCarListFragmentToVehicleDetailFragment(
                    id
                )
            )
        }, {
            viewModel.getCarsPagination()
        })
        recyclerView.adapter = adapter

        val layoutManger = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManger

        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, layoutManger.getOrientation())
        recyclerView.addItemDecoration(dividerItemDecoration)

        swiper = binding.swiperLayout
        swiper.setOnRefreshListener {
            viewModel.getCarsData()
        }

    }

    private fun subscribeToViewModel() {
        viewModel.dataStatListOfVehicles.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success -> successRespond(dataState.data)
                is DataState.Error -> errorRespond(dataState.message)
                is DataState.Loading -> loading(true)
            }

        }
    }

    private fun successRespond(item: List<VehicleListDetatil>) {
        loading(false)
        adapter.addItem(item)
        adapter.notifyDataSetChanged()
    }

    private fun errorRespond(message: String) {
        loading(false)
        Log.d("Tag", message)
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