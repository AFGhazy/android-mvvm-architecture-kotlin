package com.afghazy.framework.mvvm.ui.login

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import com.afghazy.framework.mvvm.BR
import com.afghazy.framework.mvvm.R
import com.afghazy.framework.mvvm.databinding.ActivityLoginBinding
import com.afghazy.framework.mvvm.ui.base.BaseActivity
import javax.inject.Inject


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-23
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */
 
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    @Inject
    lateinit var factory: LoginViewModel.Factory

    override val viewModel: LoginViewModel
        get() = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)

    override val layoutId: Int
        get() = R.layout.activity_login

    override val bindingVariable: Int
        get() = BR.viewModel

    companion object {
        fun intent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}