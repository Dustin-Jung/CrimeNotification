package com.android.aop.part2.crimenotification.data.source.remote

import com.android.aop.part2.crimenotification.api.KakaoApi
import com.android.aop.part2.crimenotification.api.response.KakaoSearchResponse
import com.android.aop.part2.crimenotification.util.Result
import javax.inject.Inject

class KakaoRemoteDataSourceImpl @Inject constructor(private val kakaoApi: KakaoApi) :
    KakaoRemoteDataSource {

    override suspend fun getSearchList(location: String): Result<KakaoSearchResponse> {

        return try {
            val getKakaoResponseList = kakaoApi.search(query = location).execute().body()!!
            Result.Success(getKakaoResponseList)

        } catch (e: Exception){
            Result.Error(e)
        }

    }
}