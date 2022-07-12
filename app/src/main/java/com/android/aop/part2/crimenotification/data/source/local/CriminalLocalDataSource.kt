package com.android.aop.part2.crimenotification.data.source.local

import com.android.aop.part2.crimenotification.api.response.CriminalResponse
import com.android.aop.part2.crimenotification.room.entity.CriminalEntity
import com.android.aop.part2.crimenotification.util.Result

interface CriminalLocalDataSource {

    suspend fun getLocalCriminals(): Result<List<CriminalEntity>>

    suspend fun registerCriminalEntityList(toZipList: List<CriminalEntity>): Boolean
}