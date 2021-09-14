package com.example.tragosapp.base

import android.app.Activity
import android.content.Context

import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment


fun Fragment.toast(context: Context, text: String, lenght: Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,text,lenght).show()
}

/*
fun SearchView.queryTextSubmit(listener:(String) -> Unit){
    this.setOnQueryTextListener(object:
        SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
           return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            TODO("Not yet implemented")
        }

    })
}

*/