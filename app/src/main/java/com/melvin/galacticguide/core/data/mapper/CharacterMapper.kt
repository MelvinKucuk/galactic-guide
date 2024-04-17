package com.melvin.galacticguide.core.data.mapper

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
        gender = gender
    )