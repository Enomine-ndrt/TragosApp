package com.example.tragosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.tragosapp.data.DataSource
import com.example.tragosapp.databinding.ActivityMainBinding
import com.example.tragosapp.domain.RepoImpl
import com.example.tragosapp.ui.MainFragment
import com.example.tragosapp.ui.viewModel.MainViewModel
import com.example.tragosapp.ui.viewModel.VMFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

   override fun onSupportNavigateUp():Boolean{
       return navController.navigateUp()

   }

}