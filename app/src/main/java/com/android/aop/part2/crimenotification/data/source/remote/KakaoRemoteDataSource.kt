package com.android.aop.part2.crimenotification.data.source.remote

import com.android.aop.part2.crimenotification.api.response.KakaoSearchResponse
import com.android.aop.part2.crimenotification.util.Result

interface KakaoRemoteDataSource {

    suspend fun getSearchList(location: String): Result<KakaoSearchResponse>
}