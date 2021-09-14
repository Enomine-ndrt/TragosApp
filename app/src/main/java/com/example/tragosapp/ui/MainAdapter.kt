package com.example.tragosapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tragosapp.R
import com.example.tragosapp.base.BaseViewHolder
import com.example.tragosapp.data.model.Drink
import com.example.tragosapp.databinding.TragosRowBinding

class MainAdapter(private val context: Context, private val tragosList: List<Drink>,
    private val itemClickListener:OnTragoClickListener
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener{
        fun onTragoClick(drink: Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false)
        )
    }

    override fun getItemCount(): Int = tragosList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {

        val bindind = TragosRowBinding.bind(itemView)
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.image).centerCrop().into(bindind.imgTrago)
            bindind.txtTitulo.text = item.nombre
            bindind.txtDescripcion.text = item.descripcion
            itemView.setOnClickListener { itemClickListener.onTragoClick(item) }
        }

    }

}