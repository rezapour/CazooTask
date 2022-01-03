package com.rezapour.cazootask.view.carlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rezapour.cazootask.databinding.VehicleRowBinding
import com.rezapour.cazootask.model.VehicleListDetatil
import java.util.*
import kotlin.collections.ArrayList

class VehicleLIstAdapter(
    private val vehicleList: ArrayList<VehicleListDetatil>,
    val onClick: (String) -> Unit,
    val onButtomRiched: () -> Unit,
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
        fun bindItem(vehicle: VehicleListDetatil) {
            binding.rowLayout.setOnClickListener {
                onClick(vehicle.id)
            }

            "${vehicle.make} ${vehicle.model}".also { txrVehicleName.text = it }
            textEngine.text = vehicle.displayVarient
            "${vehicle.mileage} ${vehicle.mileageUnit} ".also { txtMileAge.text = it }
            "${vehicle.registrationYear} reg".also { txtRegyear.text = it }
            vehicle.pcp.toString().let {
                if (it == "0")
                    "Not available".also { txtPcp.text = it }
                else
                    "${Currency.getInstance(vehicle.currencyCode).symbol}$it/month PCP".also {
                        txtPcp.text = it
                    }
            }
            " ${Currency.getInstance(vehicle.currencyCode).symbol}${vehicle.price.toString()}".also {
                txtPrice.text = it
            }
            Glide.with(itemView.context).load(vehicle.imageUrl)
                .into(imageViewVehicle)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = VehicleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bindItem(vehicleList[position])
        if (position == vehicleList.size - 1)
            onButtomRiched()
    }

    override fun getItemCount(): Int = vehicleList.size


    fun addItem(items: List<VehicleListDetatil>) {
        vehicleList.clear()
        vehicleList.addAll(items)
    }


}