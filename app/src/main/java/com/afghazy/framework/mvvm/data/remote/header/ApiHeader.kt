package com.afghazy.framework.mvvm.data.remote.header

import android.os.Parcelable
import dagger.Reusable
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Reusable
@Parcelize
data class ApiHeader @Inject constructor (
    val protectedApiHeader: ProtectedApiHeader,
    val publicApiHeader: PublicApiHeader
) : Parcelable