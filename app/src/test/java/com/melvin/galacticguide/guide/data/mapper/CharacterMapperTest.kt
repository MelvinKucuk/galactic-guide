package com.melvin.galacticguide.guide.data.mapper

import com.melvin.galacticguide.guide.mockCharacter
import com.melvin.galacticguide.guide.mockCharacterResponse
import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterMapperTest {

    @Test
    fun `validate correct mapping`() {
        val result = mockCharacterResponse.toDomain()

        assertEquals(mockCharacter, result)
    }
}