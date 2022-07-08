package com.android.aop.part2.crimenotification.ui.splash

import android.app.Application
import com.android.aop.part2.crimenotification.base.BaseViewModel
import com.android.aop.part2.crimenotification.data.repo.CriminalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    app: Application,
    private val criminalRepository: CriminalRepository
) : BaseViewModel(app) {
}