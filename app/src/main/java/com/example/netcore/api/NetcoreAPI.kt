package com.example.netcore.api

import com.example.netcore.api.clients.PublicAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetcoreAPI {
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://doc.linkurio.us/")
        .addConverterFactory(MoshiConverterFactory.create())

    val api: PublicAPI = retrofitBuilder
        .build()
        .create(PublicAPI::class.java)
}