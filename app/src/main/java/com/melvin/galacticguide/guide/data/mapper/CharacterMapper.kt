package com.melvin.galacticguide.guide.data.mapper

import com.melvin.galacticguide.guide.data.remote.model.CharacterResponse
import com.melvin.galacticguide.guide.domain.model.Character

fun CharacterResponse.toDomain() =
    Character(
        name = name,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        birthYear = birthYear,
        gender = gender,
        id = getIdFromUrl(url)
    )

private fun getIdFromUrl(url: String): Int {
    return url[url.lastIndex - 1].digitToInt()
}