package com.melvin.galacticguide.guide.di

import com.melvin.galacticguide.guide.data.remote.CharactersRepositoryImpl
import com.melvin.galacticguide.guide.data.remote.CharactersService
import com.melvin.galacticguide.guide.domain.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class GuideModule {

    @Provides
    fun providesCharactersService(retrofit: Retrofit): CharactersService =
        retrofit.create(CharactersService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class GuideBindsModule {

    @Binds
    abstract fun bindCharactersRepository(repository: CharactersRepositoryImpl): CharactersRepository
}