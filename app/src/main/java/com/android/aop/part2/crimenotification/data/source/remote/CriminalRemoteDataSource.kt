package com.android.aop.part2.crimenotification.data.source.remote

import com.android.aop.part2.crimenotification.api.response.CriminalResponse
import com.android.aop.part2.crimenotification.util.Result

interface CriminalRemoteDataSource {

    suspend fun getRemoteCriminals(): Result<List<CriminalResponse>>
}