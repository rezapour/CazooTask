package com.rezapour.cazootask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.rezapour.cazootask.R
import com.rezapour.cazootask.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment(), View.OnClickListener {


    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageView: ImageView
    private lateinit var btnBack: ImageButton
    private lateinit var btnForward: ImageButton
    private var postion = 0
    private val args: GalleryFragmentArgs by navArgs()
    private lateinit var imageList: Array<String>
    private lateinit var imageNumber: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageList = args.imageList
        initUi()
    }

    fun setImangeNumber() {
        val number = postion + 1
        val txt = "$number/${imageList.size}"
        imageNumber.text = txt
    }

    fun initUi() {
        imageView = binding.ivGallery
        btnBack = binding.btnBack
        btnBack.setOnClickListener(this)
        btnForward = binding.btnForward
        btnForward.setOnClickListener(this)
        imageNumber = binding.txtNumber
        loadPicture()


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnForward -> btnForward()
            R.id.btnBack -> btnBack()
        }
    }


    private fun btnForward() {
        if (postion < imageList.size - 1) {
            postion++
            loadPicture()
        }
    }

    private fun btnBack() {
        if (postion > 0) {
            postion--
            loadPicture()

        }
    }

    private fun loadPicture() {
        val circularProgressDrawable = CircularProgressDrawable(context!!)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()


        Glide.with(context!!).load(imageList[postion])
            .placeholder(circularProgressDrawable)
            .into(imageView)

        setImangeNumber()
    }


}