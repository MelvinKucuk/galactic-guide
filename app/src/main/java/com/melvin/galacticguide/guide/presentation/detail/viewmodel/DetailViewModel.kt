package com.melvin.galacticguide.guide.presentation.detail.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.galacticguide.GuideDestinationsArgs
import com.melvin.galacticguide.guide.domain.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val characterId: Int? = savedStateHandle[GuideDestinationsArgs.CHARACTER_ARG]

    private val _uiState = MutableStateFlow(DetailState())
    val uiState: StateFlow<DetailState> = _uiState.asStateFlow()

    init {
        characterId?.let {
            viewModelScope.launch {
                val character = charactersRepository.getCharacterById(it)
                _uiState.update {
                    if (character != null) {
                        it.copy(
                            character = character,
                            isLoading = false
                        )
                    } else {
                        it.copy(
                            errorMessage = "An error happened fetching the data",
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}