package com.leviaran.ownpetapp.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PetsResponseItem(
    @Json(name = "bred_for")
    val bredFor: String? = "-",
    @Json(name = "breed_group")
    val breedGroup: String? = "-",
    @Json(name = "country_code")
    val countryCode: String? = "-",
    @Json(name = "description")
    val description: String? = "-",
    @Json(name = "height")
    val height: Height? = null,
    @Json(name = "history")
    val history: String? = "-",
    @Json(name = "id")
    val id: Int? = 0,
    @Json(name = "image")
    val image: Image = Image(),
    @Json(name = "life_span")
    val lifeSpan: String? = "-",
    @Json(name = "name")
    val name: String? = "-",
    @Json(name = "origin")
    val origin: String? = "-",
    @Json(name = "reference_image_id")
    val referenceImageId: String? = "-",
    @Json(name = "temperament")
    val temperament: String? = "-",
    @Json(name = "weight")
    val weight: Weight? = null
)