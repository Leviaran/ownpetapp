package com.leviaran.ownpetapp.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Height(
    @Json(name = "imperial")
    val imperial: String,
    @Json(name = "metric")
    val metric: String
)