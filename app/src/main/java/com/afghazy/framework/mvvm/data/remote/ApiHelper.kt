package com.afghazy.framework.mvvm.data.remote

import com.afghazy.framework.mvvm.data.model.api.blog.BlogResponse
import com.afghazy.framework.mvvm.data.model.api.login.*
import com.afghazy.framework.mvvm.data.model.api.opensource.OpenSourceResponse
import com.afghazy.framework.mvvm.data.remote.header.ApiHeader
import io.reactivex.Single


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */
 
interface ApiHelper {
    val apiHeader: ApiHeader

    fun doFbLoginApiCall(request: FbLoginRequest): Single<LoginResponse>
    fun doGoogleLoginApiCall(request: GoogleLoginRequest): Single<LoginResponse>
    fun doServerLoginApiCall(request: ServerLoginRequest): Single<LoginResponse>
    fun doLogoutApiCall(): Single<LogoutResponse>
    fun getBlogApiCall(): Single<BlogResponse>
    fun getOpenSourceApiCall(): Single<OpenSourceResponse>
}