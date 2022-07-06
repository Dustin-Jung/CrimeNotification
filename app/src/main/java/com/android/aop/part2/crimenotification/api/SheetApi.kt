package com.android.aop.part2.crimenotification.api

import com.android.aop.part2.crimenotification.api.response.CriminalResponse
import retrofit2.Call
import retrofit2.http.GET

interface SheetApi {

    companion object{
        private const val URL = "api/v1/d1skgjsjp83q0"
    }

    @GET(URL)
    fun getSheetCriminals(): Call<List<CriminalResponse>>
}