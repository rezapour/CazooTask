package com.rezapour.cazootask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rezapour.cazootask.databinding.VehicleRowBinding
import com.rezapour.cazootask.model.CarsListDetatil
import java.util.*
import kotlin.collections.ArrayList

class VehicleLIstAdapter(
    private val vehicleList: ArrayList<CarsListDetatil>,
    val onClick: (String) -> Unit
) :
    RecyclerView.Adapter<VehicleLIstAdapter.VehicleViewHolder>() {

    inner class VehicleViewHolder(val binding: VehicleRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val txrVehicleName: TextView = binding.txtVehicleName
        val textEngine: TextView = binding.txtEngine
        val txtMileAge: TextView = binding.txtMileage
        val txtRegyear: TextView = binding.txtRegYear
        val txtPcp: TextView = binding.txtPcp
        val txtPrice: TextView = binding.txtPrice
        val imageViewVehicle: ImageView = binding.ivVehicleImage
        fun bindItem(vehicle: CarsListDetatil) {
            binding.rowLayout.setOnClickListener {
                onClick(vehicle.id)
            }

            txrVehicleName.text = "${vehicle.make} ${vehicle.model}"
            textEngine.text = vehicle.displayVarient
            txtMileAge.text = "${vehicle.mileage} ${vehicle.mileageUnit} "
            txtRegyear.text = "${vehicle.registrationYear} reg"
//            txtPcp.text = vehicle.pcp.toString()
            txtPrice.text =
                " ${Currency.getInstance(vehicle.currencyCode).symbol}${vehicle.price.toString()}"
            Glide.with(itemView.context).load(vehicle.imageUrl)
                .into(imageViewVehicle)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = VehicleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = vehicleList.get(position)

        holder.bindItem(vehicle)
    }

    override fun getItemCount(): Int {
        return vehicleList.size
    }

    fun addItem(items: List<CarsListDetatil>) {
        vehicleList.addAll(items)
    }


}