package com.example.minicheckout.core.dependencyinjection

import com.example.minicheckout.repository.CheckoutRepository
import com.example.minicheckout.repository.Repository
import com.example.minicheckout.repository.network.api.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesRepository(apiService: APIService): Repository = CheckoutRepository(apiService)
}