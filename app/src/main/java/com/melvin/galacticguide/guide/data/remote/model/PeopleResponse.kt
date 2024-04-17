package com.melvin.galacticguide.guide.data.remote.model

import com.squareup.moshi.Json

data class PeopleResponse(
    @Json(name = "next")
    val next: String?,
    @Json(name = "results")
    val characters: List<CharacterResponse>,
)
