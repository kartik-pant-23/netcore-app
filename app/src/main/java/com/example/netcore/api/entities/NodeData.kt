package com.example.netcore.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NodeData(
    @Json(name = "categories")
    val categories: List<String>?,
    @Json(name = "properties")
    val properties: NodeProperties,
)