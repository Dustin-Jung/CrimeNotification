package com.android.aop.part2.crimenotification.data.source.remote

import com.android.aop.part2.crimenotification.api.SheetApi
import com.android.aop.part2.crimenotification.api.response.CriminalResponse
import com.android.aop.part2.crimenotification.util.Result
import javax.inject.Inject

class CriminalRemoteDataSourceImpl @Inject constructor(private val sheetApi: SheetApi) :
    CriminalRemoteDataSource {

    override suspend fun getRemoteCriminals(): Result<List<CriminalResponse>> {
        return try {
            val getCriminalList = sheetApi.getSheetCriminals().execute().body()!!
            Result.Success(getCriminalList)

        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}