package com.example.netcore

import com.example.netcore.api.NetcoreAPI
import com.example.netcore.api.clients.PublicAPI
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ApiUnitTest {

    val api = NetcoreAPI.api

    @Test
    fun testGetGraph() {
        runBlocking {
            val response = api.getGraphData()
            val body = response.body()
            assert(body != null)
        }
    }

}