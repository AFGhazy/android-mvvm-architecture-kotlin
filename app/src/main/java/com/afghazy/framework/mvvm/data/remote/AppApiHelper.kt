package com.afghazy.framework.mvvm.data.remote

import com.afghazy.framework.mvvm.BuildConfig
import com.afghazy.framework.mvvm.data.model.api.blog.BlogResponse
import com.afghazy.framework.mvvm.data.model.api.login.*
import com.afghazy.framework.mvvm.data.model.api.opensource.OpenSourceResponse
import com.afghazy.framework.mvvm.data.remote.header.ApiHeader
import com.rx2androidnetworking.Rx2AndroidNetworking
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
    override fun doFbLoginApiCall(request: FbLoginRequest) =
        Rx2AndroidNetworking.post(BuildConfig.BASE_URL + ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
            .addHeaders(apiHeader.publicApiHeader)
            .addBodyParameter(request)
            .build()
            .getObjectSingle(LoginResponse::class.java)

    override fun doGoogleLoginApiCall(request: GoogleLoginRequest) =
        Rx2AndroidNetworking.post(BuildConfig.BASE_URL + ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
            .addHeaders(apiHeader.publicApiHeader)
            .addBodyParameter(request)
            .build()
            .getObjectSingle(LoginResponse::class.java)

    override fun doServerLoginApiCall(request: ServerLoginRequest) =
        Rx2AndroidNetworking.post(BuildConfig.BASE_URL + ApiEndPoint.ENDPOINT_SERVER_LOGIN)
            .addHeaders(apiHeader.publicApiHeader)
            .addBodyParameter(request)
            .build()
            .getObjectSingle(LoginResponse::class.java)

    override fun doLogoutApiCall() = Rx2AndroidNetworking.post(BuildConfig.BASE_URL + ApiEndPoint.ENDPOINT_LOGOUT)
        .addHeaders(apiHeader.protectedApiHeader)
        .build()
        .getObjectSingle(LogoutResponse::class.java)

    override fun getBlogApiCall() = Rx2AndroidNetworking.get(BuildConfig.BASE_URL + ApiEndPoint.ENDPOINT_BLOG)
        .addHeaders(apiHeader.protectedApiHeader)
        .build()
        .getObjectSingle(BlogResponse::class.java)

    override fun getOpenSourceApiCall() = Rx2AndroidNetworking.get(BuildConfig.BASE_URL + ApiEndPoint.ENDPOINT_OPEN_SOURCE)
        .addHeaders(apiHeader.protectedApiHeader)
        .build()
        .getObjectSingle(OpenSourceResponse::class.java)
}