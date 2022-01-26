package com.example.netcore.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EdgeData(
    @Json(name = "properties")
    val properties: EdgeProperties?,
    @Json(name = "type")
    val type: String
)