package com.afghazy.framework.mvvm.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.afghazy.framework.mvvm.utils.getLoadingDialog
import com.afghazy.framework.mvvm.utils.isNetworkConnected
import dagger.android.AndroidInjection

abstract class BaseActivity<D : ViewDataBinding, VM : BaseViewModel<*,*>> : AppCompatActivity() {

    abstract val viewModel: VM
    lateinit var viewDataBinding: D
    abstract val layoutId: Int
    abstract val bindingVariable: Int
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInject()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    fun isConnectedToInternet() = isNetworkConnected(applicationContext)

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String) = Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
            checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED

    fun hideKeyboard() {
        this.currentFocus?.windowToken?.let { wt ->
            (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.let { imm ->
                imm.hideSoftInputFromWindow(wt, 0)
            }
        }
    }

    fun showLoading() {
        progressDialog?.cancel()
    }

    fun hideLoading() {
        hideLoading()
        progressDialog = getLoadingDialog(applicationContext)
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        viewDataBinding.setVariable(bindingVariable, viewModel)
        viewDataBinding.executePendingBindings()
    }

    private fun performDependencyInject() {
        AndroidInjection.inject(this)
    }
}