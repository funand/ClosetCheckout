package com.example.minicheckout.core.dependencyinjection

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

// Dagger
@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun appCompatActivity(activity: Activity) = activity as AppCompatActivity

    @Provides
    fun layoutInflator(activity: Activity) = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager

}