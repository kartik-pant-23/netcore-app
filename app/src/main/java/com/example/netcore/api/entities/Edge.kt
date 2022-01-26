package com.example.netcore.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Edge(
    @Json(name = "data")
    val data: EdgeData,
    @Json(name = "id")
    val id: Int,
    @Json(name = "source")
    val source: Int,
    @Json(name = "target")
    val target: Int
)