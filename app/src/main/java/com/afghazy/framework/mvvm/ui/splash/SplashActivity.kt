package com.afghazy.framework.mvvm.ui.splash

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.afghazy.framework.mvvm.BR
import com.afghazy.framework.mvvm.R
import com.afghazy.framework.mvvm.databinding.ActivitySplashBinding
import com.afghazy.framework.mvvm.ui.base.BaseActivity
import javax.inject.Inject


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-18
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {
    @Inject
    lateinit var factory: SplashViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
        viewModel.startSeeding()
    }


    override fun openLogin() {

    }

    override fun openMain() {

    }

    override val viewModel: SplashViewModel
        get() = ViewModelProviders.of(this, factory).get(SplashViewModel::class.java)

    override val layoutId: Int
        get() = R.layout.activity_splash

    override val bindingVariable: Int
        get() = BR.viewModel
}