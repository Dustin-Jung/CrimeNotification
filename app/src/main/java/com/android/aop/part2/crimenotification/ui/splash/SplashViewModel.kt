package com.android.aop.part2.crimenotification.ui.splash

import android.app.Application
import com.android.aop.part2.crimenotification.api.response.CriminalResponse
import com.android.aop.part2.crimenotification.api.response.Document
import com.android.aop.part2.crimenotification.base.BaseViewModel
import com.android.aop.part2.crimenotification.data.repo.CriminalRepository
import com.android.aop.part2.crimenotification.data.repo.KakaoRepository
import com.android.aop.part2.crimenotification.ext.ioScope
import com.android.aop.part2.crimenotification.room.entity.CriminalEntity
import com.android.aop.part2.crimenotification.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    app: Application,
    private val criminalRepository: CriminalRepository,
    private val kakaoRepository: KakaoRepository
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

                    getLocationList(result.data) {

                        val toZipList = result.data.zip(it).map { zip ->
                            CriminalEntity(
                                name = zip.first.name,
                                address = zip.first.addressReal,
                                latitude = zip.second.latitude.toDouble(),
                                longitude = zip.second.longitude.toDouble()
                            )
                        }

                        ioScope {
                            if (criminalRepository.registerCriminalEntityList(toZipList)) {
                                SplashViewState.RouteHome
                            } else {
                                SplashViewState.Error("저장을 실패하였습니다. 다시 시도해 주세요.")
                            }
                        }
                    }

                }

                is Result.Error -> {

                    SplashViewState.Error("범죄자 데이터를 가지고 올 수 없습니다. 다시 시도해 주세요.")
                }
            }
        }

    }

    private suspend fun getLocationList(
        list: List<CriminalResponse>,
        callback: (List<Document>) -> Unit
    ) {

        var count = 1
        val documentList = mutableListOf<Document>()

        list.forEach {

            when (val result = kakaoRepository.getSearchList(it.addressReal)) {

                is Result.Success -> {
                    count++
                    if (result.data.documents.isNotEmpty()) {
                        documentList.add(result.data.documents[0])
                    }
                    if (count == list.size) {
                        callback(documentList)
                    }
                }

                is Result.Error -> {
                    count++
                }
            }
        }
    }

}
