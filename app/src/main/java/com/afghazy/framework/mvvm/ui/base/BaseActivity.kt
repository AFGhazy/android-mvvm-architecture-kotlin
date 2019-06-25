package com.afghazy.framework.mvvm.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.afghazy.framework.mvvm.app.MvvmApp
import com.afghazy.framework.mvvm.utils.getLoadingDialog
import com.afghazy.framework.mvvm.utils.isNetworkConnected
import com.afghazy.framework.mvvm.utils.rx.SchedulerProvider
import com.cantrowitz.rxbroadcast.RxBroadcast
import android.net.NetworkInfo.State
import com.tapadoo.alerter.Alerter
import dagger.android.AndroidInjection
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity<D : ViewDataBinding, VM : BaseViewModel<*, *>> : AppCompatActivity() {
    @Inject
    lateinit var schedulerProvider: SchedulerProvider
    @Inject
    lateinit var compositeDisposable: CompositeDisposable
    abstract val viewModel: VM
    lateinit var viewDataBinding: D
    abstract val layoutId: Int
    abstract val bindingVariable: Int
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInject()
        super.onCreate(savedInstanceState)
        performDataBinding()


        val dis = RxBroadcast.fromLocalBroadcast(this, IntentFilter().apply {
            addAction(MvvmApp.ACTION_CHANGE_NETWORK_STATE)
        }).subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({
                val state = it.getSerializableExtra(MvvmApp.EXTRA_CHANGE_NETWORK_STATE) as State
                Alerter.create(this).setText(state.toString()).setDuration(1000)
                    .show()
            }, { t: Throwable? ->
                println(t)
            }
            )


        val dis2 = isConnectedToInternet().subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe { isConnected, throwable ->
                if (throwable == null && isConnected == true) println("HELLO INTERNET")
            }

        compositeDisposable.add(dis)
        compositeDisposable.add(dis2)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    fun isConnectedToInternet(): Single<Boolean?> = isNetworkConnected(applicationContext)

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