package com.example.filmsmvvm.di

import com.example.filmsmvvm.data.repository.HitsRepositoryImpl
import com.example.filmsmvvm.data.repository.remote.HitsRemote
import com.example.filmsmvvm.domain.repositories.HitsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    @Singleton
    fun provideHitsRepository(hitsRemote: HitsRemote): HitsRepository =
        HitsRepositoryImpl(hitsRemote = hitsRemote)
}