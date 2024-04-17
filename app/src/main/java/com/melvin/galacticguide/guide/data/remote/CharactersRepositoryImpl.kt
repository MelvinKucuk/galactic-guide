package com.melvin.galacticguide.guide.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.melvin.galacticguide.guide.data.remote.pagination.CharactersPaginationSource
import com.melvin.galacticguide.guide.domain.CharactersRepository
import com.melvin.galacticguide.guide.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersService: CharactersService
) : CharactersRepository {

    override suspend fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                CharactersPaginationSource(charactersService)
            }
        ).flow
    }
}