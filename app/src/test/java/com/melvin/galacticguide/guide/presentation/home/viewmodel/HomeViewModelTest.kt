package com.melvin.galacticguide.guide.presentation.home.viewmodel

import androidx.paging.PagingData
import com.melvin.galacticguide.guide.MainCoroutineRule
import com.melvin.galacticguide.guide.domain.CharactersRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val repository: CharactersRepository = mockk()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        coEvery { repository.getCharacters() } returns flowOf(PagingData.empty())

        viewModel = HomeViewModel(repository)

        coroutineRule.dispatcher.scheduler.advanceUntilIdle()
    }

    @Test
    fun `validate OnError event updates uiState correctly`() = runTest {
        viewModel.onEvent(HomeEvent.OnError(errorMessage))

        val result = viewModel.uiState.first()

        assertEquals(errorMessage, result.errorMessage)
    }

    private val errorMessage = "An unexpected error occurred"
}