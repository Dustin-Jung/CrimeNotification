package com.android.aop.part2.crimenotification.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.aop.part2.crimenotification.room.dao.CriminalDao
import com.android.aop.part2.crimenotification.room.entity.CriminalEntity

@Database(entities = [CriminalEntity::class], version = 1)
abstract class CriminalDatabase : RoomDatabase(){
    abstract fun criminalDao(): CriminalDao
}