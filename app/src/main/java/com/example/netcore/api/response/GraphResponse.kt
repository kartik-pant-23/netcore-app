package com.example.netcore.api.response

import com.example.netcore.api.entities.Edge
import com.example.netcore.api.entities.Node
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GraphResponse(
    @field:Json(name = "nodes")
    val nodes: List<Node>,
    @field:Json(name = "edges")
    val edges: List<Edge>
)