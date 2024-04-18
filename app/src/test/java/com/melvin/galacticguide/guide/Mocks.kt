package com.melvin.galacticguide.guide

import com.melvin.galacticguide.guide.data.remote.model.CharacterResponse
import com.melvin.galacticguide.guide.domain.model.Character

val mockCharacterResponse = CharacterResponse(
    name = "Luke Skywalker",
    height = "172",
    mass = "77",
    hairColor = "blond",
    skinColor = "fair",
    eyeColor = "blue",
    birthYear = "19BBY",
    gender = "male",
    url = "https://swapi.dev/api/people/1/"
)

val mockCharacter = Character(
    name = "Luke Skywalker",
    height = "172",
    mass = "77",
    hairColor = "blond",
    skinColor = "fair",
    eyeColor = "blue",
    birthYear = "19BBY",
    gender = "male",
    id = 1
)