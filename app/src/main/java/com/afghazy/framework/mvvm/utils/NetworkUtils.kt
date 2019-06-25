package com.afghazy.framework.mvvm.utils

import android.content.Context
import android.net.NetworkInfo
import androidx.core.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork


fun isNetworkConnected(context: Context) =
    ReactiveNetwork.checkInternetConnectivity()