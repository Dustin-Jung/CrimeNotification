package com.android.aop.part2.crimenotification.ui.splash

import com.android.aop.part2.crimenotification.base.ViewState

sealed class SplashViewState: ViewState{
    object RouteHome: SplashViewState()
    data class Error(val message: String): SplashViewState()
}
