package com.android.aop.part2.crimenotification.data.repo

import com.android.aop.part2.crimenotification.data.source.local.CriminalLocalDataSource
import com.android.aop.part2.crimenotification.data.source.remote.CriminalRemoteDataSource

interface CriminalRepository: CriminalRemoteDataSource, CriminalLocalDataSource {
}