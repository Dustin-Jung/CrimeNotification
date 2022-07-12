package com.android.aop.part2.crimenotification.ui.login

import android.os.Bundle
import com.android.aop.part2.crimenotification.R
import com.android.aop.part2.crimenotification.base.BaseActivity
import com.android.aop.part2.crimenotification.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity: BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}