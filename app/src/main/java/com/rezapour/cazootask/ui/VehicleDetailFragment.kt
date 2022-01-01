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
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import com.rezapour.cazootask.R
import com.rezapour.cazootask.assets.Messages
import com.rezapour.cazootask.data.network.model.vehicles.*


@AndroidEntryPoint
class VehicleDetailFragment : Fragment(), View.OnClickListener {

    private val viewModel: VehicleDetatilViewModel by viewModels()

    private var _binding: FragmentVehicleDetailBinding? = null
    private val binding get() = _binding!!
    private val args: VehicleDetailFragmentArgs by navArgs()
    private var navControler: NavController? = null

    private lateinit var actionBar: MaterialToolbar
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
    private lateinit var btnGallery: Button
    private lateinit var btnGallet360: Button
    private lateinit var btnGalleryFallts: Button
    private lateinit var respond: VehicleNetworkEntity
    lateinit var swiper: SwipeRefreshLayout
    lateinit var vehicleId: String


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
        navControler = Navigation.findNavController(view)
        vehicleId = args.carId
        setUp()
    }

    private fun setUp() {
        setUpUi()
        subscribeToViewModel()
        viewModel.getVehicleDetail(vehicleId)
    }

    private fun subscribeToViewModel() {
        viewModel.dataState.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success -> respondSuccess(dataState.data)
                is DataState.Error -> respondError(dataState.message)
                is DataState.Loading -> uiStateBasedOnRespond("loading")
            }

        }
    }


    private fun setUpUi() {

        actionBar = binding.topAppBar
        actionBar.setNavigationOnClickListener {
            navControler!!.navigateUp()
        }

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
        btnGallery = binding.btnGallery
        btnGallery.setOnClickListener(this)
        btnGallet360 = binding.btnGallery360
        btnGallet360.setOnClickListener(this)
        btnGalleryFallts = binding.btnFallts
        btnGalleryFallts.setOnClickListener(this)
        swiper = binding.swiperDetailLayout
        swiper.setOnRefreshListener {
            viewModel.getVehicleDetail(vehicleId)
        }
    }


    private fun uiStateBasedOnRespond(state: String) {
        when (state) {
            "loading" -> {
                swiper.isRefreshing = true
                buttonState(false)
            }
            "error" -> {
                swiper.isRefreshing = false
                swiper.isEnabled = true
                buttonState(false)
            }
            "success" -> {
                swiper.isRefreshing = false
                swiper.isEnabled = false
                buttonState(true)
            }
        }
    }

    fun buttonState(isEnable: Boolean) {
        btnGallery.isEnabled = isEnable
        btnGallet360.isEnabled = isEnable
        btnGalleryFallts.isEnabled = isEnable
    }

    private fun respondError(message: String) {
        uiStateBasedOnRespond("error")
        when (message) {
            Messages.Error.INTERNET_CONNECTION_LIST -> snackBar(getString(R.string.error_internet_connection))
            Messages.Error.NO_CONTENT -> snackBar(getString(R.string.error_no_content))
            else -> snackBar(message)
        }
    }

    private fun respondSuccess(vehicle: VehicleNetworkEntity) {
        uiStateBasedOnRespond("success")
        respond = vehicle
        "${vehicle.make} ${vehicle.model}".also { txrVehicleName.text = it }
        textEngine.text = vehicle.displayVariant
        "${vehicle.mileage} ${vehicle.odometerReading.unit} ".also { txtMileAge.text = it }
        "${vehicle.registrationYear} reg".also { txtRegyear.text = it }

        vehicle.pricing.pcmPrice.pcp?.value.toString().let {
            "${Currency.getInstance(vehicle.pricing.pcmPrice.pcp?.currencyCode).symbol}$it/month PCP".also {
                txtPcp.text = it
            }
        }
        " ${Currency.getInstance(vehicle.pricing.fullPrice.currencyCode).symbol}${vehicle.pricing.fullPrice.value.toString()}".also {
            txtPrice.text = it
        }



        setImage()
        addSummary(vehicle.summaryAttributes)
        addFeature(vehicle.verifiedFeatures)
        addSpaces(vehicle.manufacturerSpecs)
        addRunningCost(vehicle.runningCosts)
    }

    private fun setImage() {
        val circularProgressDrawable = CircularProgressDrawable(context!!)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(context!!).load(respond.images.main.url)
            .placeholder(circularProgressDrawable)
            .into(imageViewVehicle)
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

    private fun snackBar(mes: String) {
        Snackbar.make(binding.layoutVehicleDetail, mes, Snackbar.LENGTH_LONG).show();
    }

    private fun directToGallary(url: Array<String>) {
        navControler!!.navigate(
            VehicleDetailFragmentDirections.actionVehicleDetailFragmentToGalleryFragment(
                url
            )
        )
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnGallery -> directToGallary(respond.imageGallery.map { data -> data.medium }
                .toTypedArray())
            R.id.btnGallery360 -> directToGallary(respond.openDoors360.map { data -> data.medium }
                .toTypedArray())
            R.id.btnFallts -> directToGallary(respond.imperfectionsGallery.map { data -> data.image.medium }
                .toTypedArray())
        }
    }
}