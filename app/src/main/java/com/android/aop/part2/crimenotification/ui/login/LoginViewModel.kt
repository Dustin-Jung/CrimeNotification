package com.android.aop.part2.crimenotification.ui.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.aop.part2.crimenotification.base.BaseViewModel
import com.android.aop.part2.crimenotification.data.repo.FirebaseRepository
import com.android.aop.part2.crimenotification.ext.ioScope
import com.android.aop.part2.crimenotification.ext.loginUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    app: Application,
    private val firebaseRepository: FirebaseRepository
) : BaseViewModel(app) {

    val inputEmailLiveData = MutableLiveData<String>()
    val inputPasswordLiveData = MutableLiveData<String>()

    fun login() {
        ioScope {
            viewStateChanged(LoginViewState.ShowProgress)
            viewStateChanged(LoginViewState.EnableInput(false))

            val checkEmail = async { checkEmail() }
            val checkPassword = async { checkPassword() }

            checkUser(checkEmail.await(), checkPassword.await())?.let {
                firebaseRepository.loginUser(it.email, it.password) { isLogin ->
                    if (isLogin) {
                        viewStateChanged(LoginViewState.RouteHome)
                    } else {
                        viewStateChanged(LoginViewState.Error("로그인을 실패하였습니다."))
                    }
                }
            }

            viewStateChanged(LoginViewState.HideProgress)
            viewStateChanged(LoginViewState.EnableInput(true))
        }


    }

    fun register() {
        viewStateChanged(LoginViewState.RouteLogin)

    }

    private fun checkUser(
        checkEmail: Boolean,
        checkPassword: Boolean,
    ): Person? {
        return if (checkEmail && checkPassword) {
            Person(inputEmailLiveData.value!!, inputPasswordLiveData.value!!)
        } else {
            null
        }
    }

    private fun checkEmail(): Boolean {
        return when {
            inputEmailLiveData.value.isNullOrEmpty() -> {
                viewStateChanged(LoginViewState.Error("이메일을 입력해 주세요."))
                false
            }
            else -> true
        }
    }

    private fun checkPassword(): Boolean {
        return when {
            inputPasswordLiveData.value.isNullOrEmpty() -> {
                viewStateChanged(LoginViewState.Error("비밀번호를 입력해 주세요."))
                false
            }
            else -> true
        }
    }

    data class Person(
        val email: String,
        val password: String
    )
}