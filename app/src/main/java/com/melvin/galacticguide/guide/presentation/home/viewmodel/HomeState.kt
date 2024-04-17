package com.melvin.galacticguide.guide.presentation.home.viewmodel

import androidx.paging.PagingData
import com.melvin.galacticguide.guide.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HomeState(
    val characterList: Flow<PagingData<Character>> = flowOf()
)
