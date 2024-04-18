package com.melvin.galacticguide.guide.presentation.detail.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.melvin.galacticguide.GuideDestinationsArgs
import com.melvin.galacticguide.guide.MainCoroutineRule
import com.melvin.galacticguide.guide.domain.CharactersRepository
import com.melvin.galacticguide.guide.domain.model.Character
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val repository: CharactersRepository = mockk()

    private val savedStateHandle = SavedStateHandle().apply {
        set(GuideDestinationsArgs.CHARACTER_ARG, 1)
    }

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        coEvery { repository.getCharacterById(any()) } returns mockCharacter

        viewModel = DetailViewModel(
            repository,
            savedStateHandle
        )

        coroutineRule.dispatcher.scheduler.advanceUntilIdle()
    }

    @Test
    fun `validate that success fetch works correctly`() {
        val result = viewModel.uiState.value

        assertEquals(
            DetailState(
                character = mockCharacter,
                isLoading = false
            ),
            result
        )
    }

    @Test
    fun `validate error response update error correctly`() {
        coEvery { repository.getCharacterById(any()) } returns null

        viewModel = DetailViewModel(
            repository,
            savedStateHandle
        )

        coroutineRule.dispatcher.scheduler.advanceUntilIdle()

        val result = viewModel.uiState.value

        assertEquals(
            DetailState(
                errorMessage = "An error happened fetching the data",
                isLoading = false
            ),
            result
        )
    }

    @Test
    fun `validate null arguments does not update the state`() {
        val savedStateHandle = SavedStateHandle().apply {
            set(GuideDestinationsArgs.CHARACTER_ARG, 1)
        }

        viewModel = DetailViewModel(
            repository,
            savedStateHandle
        )

        val result = viewModel.uiState.value

        assertEquals(
            DetailState(),
            result
        )
    }

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