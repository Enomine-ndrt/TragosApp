package com.example.tragosapp.data

import com.example.tragosapp.data.model.Drink
import com.example.tragosapp.vo.Resource
import com.example.tragosapp.vo.RetrofitClient

class DataSource {
//from webservice
        suspend fun getTragoByName(tragoName:String):Resource<List<Drink>>{
            return Resource.Success(RetrofitClient.webservice.getTragoByName(tragoName).drinkList)
        }
//local data
/*
        val generateTragosList = Resource.Success(listOf(
            Drink("https://cdn5.recetasdeescandalo.com/wp-content/uploads/2018/09/Coctel-margarita-como-prepararlo.-Receta-e-ingredientes.jpg","Margarita","Con azucar,vodka y nueces"),
            Drink("https://2.bp.blogspot.com/_53Az4HxBuYw/TCe-UaAz5aI/AAAAAAAAB5Q/xjEIprkWFoo/s1600/fernet+cola.jpg","Ferned","Fernet con Coca y 2 hielos"),
            Drink("https://pbs.twimg.com/media/CERSHJwXIAATqjl.jpg","Toro","Toro con pritty"),
            Drink("https://64.media.tumblr.com/2a00c67fe2becf9e6704245c2432e625/tumblr_ny82d7tHAT1u916tro1_640.jpg","Gancia","Gancia con sprite")
        ))
*/

}