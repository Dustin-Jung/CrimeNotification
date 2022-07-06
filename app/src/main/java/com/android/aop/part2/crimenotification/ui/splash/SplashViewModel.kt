package com.android.aop.part2.crimenotification.ui.splash

import android.app.Application
import com.android.aop.part2.crimenotification.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(app: Application): BaseViewModel(app){
}