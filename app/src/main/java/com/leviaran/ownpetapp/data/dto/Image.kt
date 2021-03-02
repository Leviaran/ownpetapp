package com.leviaran.ownpetapp.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "height")
    val height: Int? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "url")
    val url: String? = "-",
    @Json(name = "width")
    val width: Int? = null
)