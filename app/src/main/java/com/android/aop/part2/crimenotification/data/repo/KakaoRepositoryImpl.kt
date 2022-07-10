package com.android.aop.part2.crimenotification.data.repo

import com.android.aop.part2.crimenotification.api.response.KakaoSearchResponse
import com.android.aop.part2.crimenotification.data.source.remote.KakaoRemoteDataSource
import com.android.aop.part2.crimenotification.util.Result
import javax.inject.Inject

class KakaoRepositoryImpl @Inject constructor(private val kakaoRemoteDataSource: KakaoRemoteDataSource) :
    KakaoRepository {

    override suspend fun getSearchList(location: String): Result<KakaoSearchResponse> =
        kakaoRemoteDataSource.getSearchList(location)

}