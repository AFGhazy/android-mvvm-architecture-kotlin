package com.afghazy.framework.mvvm.utils

import android.content.Context
import android.net.NetworkInfo
import androidx.core.content.ContextCompat.getSystemService
import android.net.ConnectivityManager


fun isNetworkConnected(context: Context) =
    (context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)?.let {
        it.isDefaultNetworkActive
    } ?: false