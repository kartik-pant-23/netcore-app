package com.example.netcore.api.clients

import com.example.netcore.api.response.GraphResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PublicAPI {

    @GET("ogma/latest/resources/files/solarCity.json")
    suspend fun getGraphData(): Response<GraphResponse>

}