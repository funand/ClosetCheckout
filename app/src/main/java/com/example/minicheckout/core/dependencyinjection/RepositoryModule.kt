package com.example.minicheckout.core.dependencyinjection

import com.example.minicheckout.repository.Repository
import com.example.minicheckout.repository.network.api.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(apiService: APIService): Repository {
        return Repository(apiService)
    }

}