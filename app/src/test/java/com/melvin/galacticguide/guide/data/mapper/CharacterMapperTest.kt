package com.melvin.galacticguide.guide.data.mapper

import com.melvin.galacticguide.guide.data.remote.model.CharacterResponse
import com.melvin.galacticguide.guide.domain.model.Character
import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterMapperTest {

    @Test
    fun `validate correct mapping`() {
        val result = mockCharacterResponse.toDomain()

        assertEquals(mockCharacter, result)
    }

    private val mockCharacterResponse = CharacterResponse(
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

    private val mockCharacter = Character(
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
}