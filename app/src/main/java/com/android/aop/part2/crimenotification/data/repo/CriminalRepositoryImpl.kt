package com.android.aop.part2.crimenotification.data.repo

import com.android.aop.part2.crimenotification.api.response.CriminalResponse
import com.android.aop.part2.crimenotification.data.source.local.CriminalLocalDataSource
import com.android.aop.part2.crimenotification.data.source.remote.CriminalRemoteDataSource
import com.android.aop.part2.crimenotification.room.entity.CriminalEntity
import com.android.aop.part2.crimenotification.util.Result
import javax.inject.Inject

class CriminalRepositoryImpl @Inject constructor(
    private val criminalRemoteDataSource: CriminalRemoteDataSource,
    private val criminalLocalDataSource: CriminalLocalDataSource
) : CriminalRepository {


    override suspend fun getRemoteCriminals(): Result<List<CriminalResponse>> =
        criminalRemoteDataSource.getRemoteCriminals()

    override suspend fun getLocalCriminals(): Result<List<CriminalEntity>> =
        criminalLocalDataSource.getLocalCriminals()

    override suspend fun registerCriminalEntityList(toZipList: List<CriminalEntity>): Boolean =
        criminalLocalDataSource.registerCriminalEntityList(toZipList)

}