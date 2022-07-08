package com.android.aop.part2.crimenotification.data.repo

import com.android.aop.part2.crimenotification.api.response.CriminalResponse
import com.android.aop.part2.crimenotification.data.source.remote.CriminalRemoteDataSource
import com.android.aop.part2.crimenotification.util.Result
import javax.inject.Inject

class CriminalRepositoryImpl @Inject constructor(private val criminalRemoteDataSource: CriminalRemoteDataSource) :
    CriminalRepository {


    override suspend fun getRemoteCriminals(): Result<List<CriminalResponse>> =
        criminalRemoteDataSource.getRemoteCriminals()



}