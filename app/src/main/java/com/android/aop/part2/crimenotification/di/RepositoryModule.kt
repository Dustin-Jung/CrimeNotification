package com.android.aop.part2.crimenotification.di

import com.android.aop.part2.crimenotification.data.repo.CriminalRepository
import com.android.aop.part2.crimenotification.data.repo.CriminalRepositoryImpl
import com.android.aop.part2.crimenotification.data.source.remote.CriminalRemoteDataSource
import com.android.aop.part2.crimenotification.data.source.remote.CriminalRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindCriminalRepository(criminalRepositoryImpl: CriminalRepositoryImpl): CriminalRepository

    @Singleton
    @Binds
    abstract fun bindCriminalRemoteDataSource(criminalRemoteDataSourceImpl: CriminalRemoteDataSourceImpl): CriminalRemoteDataSource
}