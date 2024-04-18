package com.melvin.galacticguide.guide.data.remote

import com.melvin.galacticguide.guide.MainCoroutineRule
import com.melvin.galacticguide.guide.data.remote.model.CharacterResponse
import com.melvin.galacticguide.guide.domain.CharactersRepository
import com.melvin.galacticguide.guide.mockCharacter
import com.melvin.galacticguide.guide.mockCharacterResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.internal.http.RealResponseBody
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class CharactersRepositoryImplTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val charactersService: CharactersService = mockk()

    private lateinit var repository: CharactersRepository

    @Before
    fun setUp() {
        repository = CharactersRepositoryImpl(
            charactersService = charactersService
        )
    }

    @Test
    fun `validate success response returns correct data`() = runTest {
        coEvery { charactersService.getCharacterById(any()) } returns mockResponse

        val result = repository.getCharacterById(1)

        coroutineRule.dispatcher.scheduler.advanceUntilIdle()

        assertEquals(mockCharacter, result)
    }

    @Test
    fun `validate error response returns correct data`() = runTest {
        coEvery { charactersService.getCharacterById(any()) } returns mockResponseError

        val result = repository.getCharacterById(1)

        coroutineRule.dispatcher.scheduler.advanceUntilIdle()

        assertEquals(null, result)
    }

    private val mockResponse = Response.success(mockCharacterResponse)

    private val mockResponseError = Response.error<CharacterResponse>(
        404,
        RealResponseBody(
            contentTypeString = "",
            contentLength = 0L,
            source = Buffer()
        )
    )
}