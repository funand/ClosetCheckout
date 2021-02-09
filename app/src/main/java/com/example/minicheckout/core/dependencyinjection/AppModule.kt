package com.example.minicheckout.core.dependencyinjection

import android.app.Application
import com.example.minicheckout.core.coroutines.AppCoroutineContextProvider
import com.example.minicheckout.core.coroutines.CoroutineContextProvider
import com.example.minicheckout.repository.network.api.TestAPI
import com.example.minicheckout.main.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

//Dagger
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun app(application: Application): MainApplication = application as MainApplication

    @Provides
    fun contextProvider(): CoroutineContextProvider = AppCoroutineContextProvider()

    @Provides
    fun provideAPIService() = TestAPI.apiService
}