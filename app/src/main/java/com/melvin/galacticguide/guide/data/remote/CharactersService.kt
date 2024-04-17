package com.melvin.galacticguide.guide.data.remote

import com.melvin.galacticguide.guide.data.remote.model.CharacterResponse
import com.melvin.galacticguide.guide.data.remote.model.PeopleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersService {

    @GET("people/")
    suspend fun getCharacters(@Query("page") pageNumber: Int): Response<PeopleResponse>

    @GET("people/{id}")
    suspend fun getCharacterById(@Path("id") characterId: Int): Response<CharacterResponse>
}