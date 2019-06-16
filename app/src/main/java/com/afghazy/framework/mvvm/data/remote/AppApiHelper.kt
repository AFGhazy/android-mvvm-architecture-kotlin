package com.afghazy.framework.mvvm.data.remote

import com.afghazy.framework.mvvm.data.model.api.blog.BlogResponse
import com.afghazy.framework.mvvm.data.model.api.login.FbLoginRequest
import com.afghazy.framework.mvvm.data.model.api.login.GoogleLoginRequest
import com.afghazy.framework.mvvm.data.model.api.login.LoginResponse
import com.afghazy.framework.mvvm.data.model.api.login.ServerLoginRequest
import com.afghazy.framework.mvvm.data.model.api.opensource.OpenSourceResponse
import com.afghazy.framework.mvvm.data.remote.header.ApiHeader
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Singleton
class AppApiHelper @Inject constructor(
    override val apiHeader: ApiHeader
) : ApiHelper {

    override fun doFbLoginApiCall(request: FbLoginRequest): Single<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doGoogleLoginApiCall(request: GoogleLoginRequest): Single<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doServerLoginApiCall(request: ServerLoginRequest): Single<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBlogApiCall(): Single<BlogResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOpenSourceApiCall(): Single<OpenSourceResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}