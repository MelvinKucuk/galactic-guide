package com.melvin.galacticguide.guide.data.remote.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.melvin.galacticguide.core.data.Resource
import com.melvin.galacticguide.core.data.remote.safeApiCall
import com.melvin.galacticguide.guide.data.mapper.toDomain
import com.melvin.galacticguide.guide.data.remote.CharactersService
import com.melvin.galacticguide.guide.domain.model.Character

class CharactersPaginationSource(
    private val charactersService: CharactersService
) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val response = safeApiCall { charactersService.getCharacters(pageNumber = page) }

            when (response) {
                is Resource.Success -> LoadResult.Page(
                    data = response.data.characters.map { it.toDomain() },
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = getNextPage(response.data.next),
                )

                is Resource.Error -> LoadResult.Error(Throwable("error"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun getNextPage(url: String?): Int? {
        return url?.lastIndex?.let { url[it].digitToInt() }
    }
}
