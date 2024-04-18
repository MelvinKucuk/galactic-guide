package com.melvin.galacticguide.guide.presentation.home.viewmodel

import com.melvin.galacticguide.guide.domain.model.Character

sealed interface HomeEvent {
    data class OnError(val message: String) : HomeEvent
    data class OnCharacterClick(val selectedCharacter: Character?) : HomeEvent
}