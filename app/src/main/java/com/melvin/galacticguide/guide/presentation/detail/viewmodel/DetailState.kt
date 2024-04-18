package com.melvin.galacticguide.guide.presentation.detail.viewmodel

import com.melvin.galacticguide.guide.domain.model.Character

data class DetailState(
    val character: Character? = null,
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)
