package com.afghazy.framework.mvvm.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.afghazy.framework.mvvm.utils.isNetworkConnected
import dagger.android.AndroidInjection

abstract class BaseActivity<D : ViewDataBinding, N, VM: BaseViewModel<N>>: AppCompatActivity() {

    abstract val viewModel: BaseViewModel<N>
    lateinit var viewDataBinding: ViewDataBinding
    abstract val layoutId: Int
    abstract val bindingVariable: Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        performDependencyInject()
        super.onCreate(savedInstanceState, persistentState)
        performDataBinding()
    }

    fun isConnectedToInternet() = isNetworkConnected(applicationContext)

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        viewDataBinding.setVariable(bindingVariable, viewModel)
        viewDataBinding.executePendingBindings()
    }

    private fun performDependencyInject() {
        AndroidInjection.inject(this)
    }
}