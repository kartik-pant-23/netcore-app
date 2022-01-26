package com.example.netcore.api.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Node(
    @Json(name = "data")
    val data: NodeData,
    @Json(name = "id")
    val id: Int
)
