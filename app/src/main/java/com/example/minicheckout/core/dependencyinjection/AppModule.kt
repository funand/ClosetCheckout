package com.example.minicheckout.core.dependencyinjection

import android.app.Application
import com.example.minicheckout.core.coroutines.AppCoroutineContextProvider
import com.example.minicheckout.core.coroutines.CoroutineContextProvider
import com.example.minicheckout.main.MainApplication
import com.example.minicheckout.repository.network.api.APIService
import com.example.minicheckout.repository.network.api.TestAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//Dagger
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun app(application: Application): MainApplication = application as MainApplication

    @Provides
    fun contextProvider(): CoroutineContextProvider = AppCoroutineContextProvider()

    @Provides
    fun provideAPIService(): APIService = TestAPI.apiService
}