package com.android.aop.part2.crimenotification.di

import com.android.aop.part2.crimenotification.api.SheetApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideSheetApi(): SheetApi {
        return Retrofit.Builder()
            .baseUrl(SHEET_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SheetApi::class.java)

    }

    private const val SHEET_URL = "https://sheetdb.io/"
}