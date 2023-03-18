package com.example.filmsmvvm.di

import com.example.filmsmvvm.data.remote.api.HitsApi
import com.example.filmsmvvm.data.repository.impl.HitsRemoteImpl
import com.example.filmsmvvm.data.repository.remote.HitsRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideHitsRemote(hitsApi: HitsApi): HitsRemote =
        HitsRemoteImpl(hitsApi = hitsApi)
}