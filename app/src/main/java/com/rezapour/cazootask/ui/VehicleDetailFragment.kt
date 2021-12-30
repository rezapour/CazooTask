package com.rezapour.cazootask.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.rezapour.cazootask.databinding.FragmentVehicleDetailBinding
import com.rezapour.cazootask.databinding.SummaryRowBinding
import com.rezapour.cazootask.util.DataState
import com.rezapour.cazootask.viewmodel.VehicleDetatilViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import android.widget.LinearLayout

import android.widget.TextView
import com.rezapour.cazootask.data.network.model.vehicles.*


@AndroidEntryPoint
class VehicleDetailFragment : Fragment() {

    private val viewModel: VehicleDetatilViewModel by viewModels()

    private var _binding: FragmentVehicleDetailBinding? = null
    private val binding get() = _binding!!
    private val args: VehicleDetailFragmentArgs by navArgs()

    private lateinit var txrVehicleName: TextView
    private lateinit var textEngine: TextView
    private lateinit var txtMileAge: TextView
    private lateinit var txtRegyear: TextView
    private lateinit var txtPcp: TextView
    private lateinit var txtPrice: TextView
    private lateinit var imageViewVehicle: ImageView
    private lateinit var layoutSummery: LinearLayout
    private lateinit var layoutExterior: LinearLayout
    private lateinit var layoutInterior: LinearLayout
    private lateinit var layoutPerformance: LinearLayout
    private lateinit var layoutWeight: LinearLayout
    private lateinit var layoutRunningCost: LinearLayout


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
        val id = args.carId
        setUp(id)
    }

    private fun setUp(VehicleId: String) {
        setUpUi()
        subscribeToViewModel()
        viewModel.getVehicleDetail(VehicleId)
    }

    private fun subscribeToViewModel() {
        viewModel.dataState.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success -> respondSuccess(dataState.data)
                is DataState.Error -> Log.d("TAG", "Error=${dataState.message}")
                is DataState.Loading -> Log.d("TAG", "Loading")

            }

        }
    }


    private fun setUpUi() {
        txrVehicleName = binding.txtVehicleDetailName
        textEngine = binding.txtEngineDetail
        txtMileAge = binding.txtMileageDetail
        txtRegyear = binding.txtRegYearDetail
        txtPcp = binding.txtPcpDetail
        txtPrice = binding.txtPriceDetail
        imageViewVehicle = binding.ivVehicelPic
        layoutSummery = binding.layoutSummary
        layoutExterior = binding.layoutExterior
        layoutInterior = binding.layoutInterior
        layoutPerformance = binding.layoutPerformance
        layoutWeight = binding.layoutWeight
        layoutRunningCost = binding.layoutRunningCost
    }

    private fun respondSuccess(vehicle: VehicleNetworkEntity) {
        "${vehicle.make} ${vehicle.model}".also { txrVehicleName.text = it }
        textEngine.text = vehicle.displayVariant
        "${vehicle.mileage} ${vehicle.odometerReading.unit} ".also { txtMileAge.text = it }
        "${vehicle.registrationYear} reg".also { txtRegyear.text = it }
//            txtPcp.text = vehicle.pcp.toString()
        " ${Currency.getInstance(vehicle.pricing.fullPrice.currencyCode).symbol}${vehicle.pricing.fullPrice.value.toString()}".also {
            txtPrice.text = it
        }
        Glide.with(context!!).load(vehicle.images.main.url)
            .into(imageViewVehicle)

        addSummary(vehicle.summaryAttributes)
        addFeature(vehicle.verifiedFeatures)
        addSpaces(vehicle.manufacturerSpecs)
        addRunningCost(vehicle.runningCosts)
    }


    private fun addSummary(summaryAttributes: List<DisplayValueNetworkEntity>) {
        for (att in summaryAttributes)
            addDataLayout(att.displayLabel, att.displayValue, layoutSummery)
    }

    private fun addFeature(features: List<VerifiedFeaturesNetWorkEntity>) {
        for (feature in features) {
            if (feature.location == "Exterior")
                addDataLayout(feature.displayLabel, "", layoutExterior)
            else
                addDataLayout(feature.displayLabel, "", layoutInterior)

        }
    }

    private fun addSpaces(manufacturerSpecs: List<ManufacturerSpecsNetWorkEntity>) {
        for (specs in manufacturerSpecs) {
            val layout = if (specs.identifier == "performanceAndEconomy")
                layoutPerformance
            else if (specs.identifier == "weightAndDimensions")
                layoutWeight
            else
                continue
            for (value in specs.displayValue)
                addDataLayout(value.displayLabel, value.displayValue, layout)
        }
    }

    private fun addRunningCost(runningCosts: RunningCostsNetWorkEntity) {
        val insurance =
            "Group ${runningCosts.insuranceGroup} [approx. ${Currency.getInstance(runningCosts.insuranceCostPerYear.currencyCode).symbol}${runningCosts.insuranceCostPerYear.value}/year]"
        addDataLayout("Insurance", insurance, layoutRunningCost)

        val fuelConsumption =
            "${runningCosts.fuelConsumptionMpg}mpg [approx. ${Currency.getInstance(runningCosts.fuelConsumptionCostPerWeek.currencyCode).symbol}${runningCosts.fuelConsumptionCostPerWeek.value.toInt()}/year]"
        addDataLayout("Fuel consumption", fuelConsumption, layoutRunningCost)
    }


    private fun addDataLayout(lable: String, value: String, layout: LinearLayout) {
        val summryRow = SummaryRowBinding.inflate(layoutInflater)
        summryRow.txtValueSummary.text = value
        summryRow.txtLableSummary.text = lable

        layout.addView(summryRow.root, layout.childCount)

    }
}