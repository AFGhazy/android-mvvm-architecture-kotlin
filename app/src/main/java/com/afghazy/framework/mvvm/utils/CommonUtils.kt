package com.afghazy.framework.mvvm.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import java.nio.charset.Charset
import androidx.sqlite.db.SupportSQLiteDatabase
import com.afghazy.framework.mvvm.BuildConfig
import com.afghazy.framework.mvvm.R


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-18
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */
 
fun getLoadingDialog(context: Context) = ProgressDialog(context).apply {
    show()
    window?.let {
        it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    setContentView(R.layout.progress_dialog)
    isIndeterminate = true
    setCancelable(false)
    setCanceledOnTouchOutside(false)
}

fun loadJSONFromAsset(context: Context, jsonFileName: String): String {
    val manager = context.assets
    val inputStream = manager.open(jsonFileName)

    val size = inputStream.available()
    val buffer = ByteArray(size)
    inputStream.read(buffer)
    inputStream.close()

    return String(buffer, Charset.forName("UTF-8"))
}