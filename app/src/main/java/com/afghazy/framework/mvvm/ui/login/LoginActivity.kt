package com.afghazy.framework.mvvm.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigator {
    @Inject
    lateinit var factory: LoginViewModel.Factory

    override val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
    }

    override val layoutId: Int
        get() = R.layout.activity_login

    override val bindingVariable: Int
        get() = BR.viewModel

    companion object {
        fun intent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
    }

    override fun login() {
        val email = viewDataBinding.etEmail.text.toString()
        val pass = viewDataBinding.etPassword.text.toString()
        val valid = viewModel.isEmailAndPasswordValid(email, pass)

        if(valid) {
            hideKeyboard()
            viewModel.login(email, pass)
        } else {
            Toast.makeText(this, R.string.invalid_email_password, Toast.LENGTH_SHORT).show()
        }
    }

    override fun openMain() {

    }
}