package com.android.aop.part2.crimenotification.data.source.local

import com.android.aop.part2.crimenotification.room.dao.CriminalDao
import com.android.aop.part2.crimenotification.room.entity.CriminalEntity
import com.android.aop.part2.crimenotification.util.Result
import javax.inject.Inject

class CriminalLocalDataSourceImpl @Inject constructor(private val criminalDao: CriminalDao) :
    CriminalLocalDataSource {
    override suspend fun getLocalCriminals(): Result<List<CriminalEntity>> {
        return try {
            Result.Success(criminalDao.getAll())
        } catch (e: Exception){
            Result.Error(e)
        }
    }
}