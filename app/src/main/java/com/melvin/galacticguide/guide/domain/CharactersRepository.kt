package com.melvin.galacticguide.guide.domain

import androidx.paging.PagingData
import com.melvin.galacticguide.guide.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getCharacters(): Flow<PagingData<Character>>

    suspend fun getCharacterById(id: Int): Character?
}