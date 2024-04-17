package com.melvin.galacticguide.guide.data.remote.model

import com.squareup.moshi.Json

data class CharacterResponse(
    @Json(name = "name")
    val name: String,
    @Json(name = "height")
    val height: String,
    @Json(name = "mass")
    val mass: String,
    @Json(name = "hair_color")
    val hairColor: String,
    @Json(name = "skin_color")
    val skinColor: String,
    @Json(name = "eye_color")
    val eyeColor: String,
    @Json(name = "birth_year")
    val birthYear: String,
    @Json(name = "gender")
    val gender: String
)
