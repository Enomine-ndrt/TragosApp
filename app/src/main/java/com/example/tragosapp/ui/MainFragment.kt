package com.example.tragosapp.ui

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tragosapp.R
import com.example.tragosapp.base.toast
import com.example.tragosapp.data.DataSource
import com.example.tragosapp.data.model.Drink
import com.example.tragosapp.databinding.FragmentMainBinding

import com.example.tragosapp.domain.RepoImpl
import com.example.tragosapp.ui.viewModel.MainViewModel
import com.example.tragosapp.ui.viewModel.VMFactory
import com.example.tragosapp.vo.Resource


class MainFragment : Fragment(),MainAdapter.OnTragoClickListener{
    private var _binding: FragmentMainBinding? = null
    private val binding  get() = _binding!!

    private val viewModel by viewModels<MainViewModel>{
        VMFactory(RepoImpl(DataSource()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSearchView()
        setupObservers()
    }

    private fun setupObservers(){
        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer {result ->
            when(result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvTragos.adapter = MainAdapter(requireContext(),result.data,this)
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    toast(requireContext(),"ha ocurrido un  error ${result.exception}")
                    Log.e("Error","no carga ${result.exception}")
                }
            }
        })
    }

    private fun setupSearchView(){

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setTrago(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })


    }

    override fun onTragoClick(drink: Drink) {
        val bundle = Bundle()
        bundle.putParcelable("drink",drink)
       findNavController().navigate(R.id.action_mainFragment_to_tragosDetalleFragment,bundle)
    }

    private fun setupRecyclerView() {

        binding.rvTragos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTragos.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }


}