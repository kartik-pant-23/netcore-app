package com.example.netcore.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NodeProperties(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String?,
    @Json(name = "permalink")
    val permalink: String?,
    @Json(name = "picture")
    val picture: String?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "first_funding_at")
    val firstFundingAt: String?,
    @Json(name = "founded_at")
    val foundedAt: String?,
    @Json(name = "founded_month")
    val foundedMonth: String?,
    @Json(name = "founded_quarter")
    val foundedQuarter: String?,
    @Json(name = "founded_year")
    val foundedYear: Int?,
    @Json(name = "funding_rounds")
    val fundingRounds: Int?,
    @Json(name = "funding_total")
    val fundingTotal: Int?,
    @Json(name = "homepage_url")
    val homepageUrl: String?,
    @Json(name = "last_funding_at")
    val lastFundingAt: String?,
    @Json(name = "logo")
    val logo: String?,
    @Json(name = "market")
    val market: String?,
    @Json(name = "region")
    val region: String?,
    @Json(name = "state")
    val state: String?,
    @Json(name = "status")
    val status: String?
)