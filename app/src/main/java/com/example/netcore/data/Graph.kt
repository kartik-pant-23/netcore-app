package com.example.netcore.data

import com.example.netcore.api.entities.Edge
import com.example.netcore.api.entities.Node

class Graph {
    private var nodes: MutableList<Node> = mutableListOf()
    private var edges: MutableList<Edge> = mutableListOf()

    private var source: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    private var target: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    fun insertNodes(nodesList: List<Node>) {
        nodes.addAll(nodesList)
    }

    fun getNodesByType(type: String): List<Node> {
        return nodes.filter {
            it.data.categories?.contains(type) ?: false
        }
    }

    fun insertEdges(edgesList: List<Edge>) {
        edges.addAll(edgesList)
        for (i in 0 until edges.size) {
            if (!source.containsKey(edges[i].source)) source[edges[i].source] = mutableListOf()
            if (!target.containsKey(edges[i].target)) target[edges[i].target] = mutableListOf()

            source[edges[i].source]?.add(i)
            target[edges[i].target]?.add(i)
        }
    }

    fun getNode(id: Int) : Node {
        for (node in nodes) {
            if (node.id == id) return node
        }
        return nodes[0]
    }

    fun getInvestedAt(node_id: Int): List<String> {
        val nodesList = mutableListOf<String>()
        source[node_id]?.forEach {
            val node = getNode(edges[it].target)
            val date = edges[it].data.properties?.fundedAt ?: edges[it].data.properties?.acquisitionDate ?: "Error"
            nodesList.add("${node.data.properties.name} (Date - $date)")
        }
        return nodesList
    }

    fun getInvestmentFrom(node_id: Int): List<String> {
        val nodesList = mutableListOf<String>()
        target[node_id]?.forEach {
            val node = getNode(edges[it].target)
            val date = edges[it].data.properties?.fundedAt ?: edges[it].data.properties?.acquisitionDate ?: "Error"
            nodesList.add("${node.data.properties.name} (Date - $date)")
        }
        return nodesList
    }

    companion object {
        const val COMPANY = "COMPANY"
        const val INVESTOR = "INVESTOR"
    }
}