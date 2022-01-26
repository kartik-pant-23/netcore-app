package com.example.netcore.view_models

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netcore.api.NetcoreAPI
import com.example.netcore.api.entities.Node
import com.example.netcore.api.response.GraphResponse
import com.example.netcore.data.Graph
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    private val api = NetcoreAPI.api
    private var _graphResponse: MutableLiveData<GraphResponse> = MutableLiveData()
    val graphResponse: LiveData<GraphResponse> = _graphResponse

    private val graph = Graph()

    fun getGraphData() = viewModelScope.launch {
        val response = api.getGraphData()
        val graphData = response.body()
        if (response.isSuccessful && graphData != null) {
            _graphResponse.postValue(graphData!!)
            graph.insertNodes(graphData.nodes)
            graph.insertEdges(graphData.edges)
        }
    }

    fun getNodesByCategory(type: String) = graph.getNodesByType(type)
    fun getNodeFromId(id: Int): Node = graph.getNode(id)
    fun getInvestedAt(node_id: Int): List<String> = graph.getInvestedAt(node_id)
    fun getInvestmentFrom(node_id: Int): List<String> = graph.getInvestmentFrom(node_id)
}