package com.example.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tragosapp.R
import com.example.tragosapp.data.model.Drink
import com.example.tragosapp.databinding.FragmentTragosDetalleBinding

class TragosDetalleFragment : Fragment() {

    private var _binding: FragmentTragosDetalleBinding? = null
    private val binding get() = _binding!!
    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable<Drink>("drink")!!
            // Log.d("Detalles_FRAG","drink ${drink.toString()}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTragosDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.image).centerCrop().into(binding.imgTrago)
        binding.tragoTitle.text = drink.nombre

        binding.tragoDesc.text = drink.descripcion
        if (drink.hasAlcoholic == "Non_Alcoholic") {
            binding.txtHasAlcohol.text = "Bebida sin alcohol"
        }else{
            binding.txtHasAlcohol.text = "Bebida con alcohol"
        }


    }

}