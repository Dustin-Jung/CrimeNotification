package com.android.aop.part2.crimenotification.ui.login

import com.android.aop.part2.crimenotification.base.ViewState

sealed class LoginViewState : ViewState {
    object RouteLogin : LoginViewState()
    object RouteHome : LoginViewState()
    data class Error(val message: String) : LoginViewState()
    data class EnableInput(val isEnable: Boolean) : LoginViewState()
    object ShowProgress : LoginViewState()
    object HideProgress : LoginViewState()
}
