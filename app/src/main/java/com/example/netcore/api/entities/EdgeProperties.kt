package com.example.netcore.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EdgeProperties(
    @Json(name = "funded_at")
    val fundedAt: String?,
    @Json(name = "funded_month")
    val fundedMonth: String?,
    @Json(name = "funded_quarter")
    val fundedQuarter: String?,
    @Json(name = "funded_year")
    val fundedYear: Int?,
    @Json(name = "funding_round_code")
    val fundingRoundCode: String?,
    @Json(name = "funding_round_type")
    val fundingRoundType: String?,
    @Json(name = "permalink")
    val permalink: String?,
    @Json(name = "raised_amount_usd")
    val raisedAmountUsd: Int?,
    @Json(name = "acquisition_date")
    val acquisitionDate: String?,
    @Json(name = "month")
    val acquisitionMonth: String?,
    @Json(name = "quarter")
    val acquisitonQuarter: String?,
    @Json(name = "year")
    val acquisitionYear: Int?,
    @Json(name = "currency")
    val priceAmountCurrency: String?,
    @Json(name = "price_amount")
    val priceAmount: Int?,
)