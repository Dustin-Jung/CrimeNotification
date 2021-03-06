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

    override suspend fun registerCriminalEntityList(toZipList: List<CriminalEntity>): Boolean {
        return try {
            registerAll(toZipList)
        } catch (e: Exception) {
            false
        }
    }

    private fun registerAll(list: List<CriminalEntity>): Boolean {
        var isAllSave = true
        list.forEach {
            isAllSave = isAllSave.and(criminalDao.registerCriminalEntity(it) > 0)
        }
        return isAllSave
    }
}