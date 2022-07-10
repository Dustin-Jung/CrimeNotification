package com.android.aop.part2.crimenotification.ui.splash

import android.app.Application
import com.android.aop.part2.crimenotification.base.BaseViewModel
import com.android.aop.part2.crimenotification.data.repo.CriminalRepository
import com.android.aop.part2.crimenotification.ext.ioScope
import com.android.aop.part2.crimenotification.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    app: Application,
    private val criminalRepository: CriminalRepository
) : BaseViewModel(app) {

    init {
        checkSaveCriminals()
    }

    private fun checkSaveCriminals() {

        ioScope {
            when (val result = criminalRepository.getLocalCriminals()) {

                is Result.Success -> {
                    if (result.data.isEmpty()) {
                        loadCriminals()
                    } else {
                       SplashViewState.RouteHome
                    }
                }

                is Result.Error -> {
                    SplashViewState.Error("저장된 범죄자 데이터를 가지고 올 수 없습니다. 다시 시도해 주세요.")
                }


            }
        }

    }

    private fun loadCriminals() {

        ioScope {
            when (val result = criminalRepository.getRemoteCriminals()) {

                is Result.Success -> {


                }

                is Result.Error -> {

                }
            }
        }

    }



}