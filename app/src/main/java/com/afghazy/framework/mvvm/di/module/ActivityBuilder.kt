package com.afghazy.framework.mvvm.di.module

import com.afghazy.framework.mvvm.ui.feed.FeedActivity
import com.afghazy.framework.mvvm.ui.feed.FeedActivityModule
import com.afghazy.framework.mvvm.ui.feed.blogs.BlogFragmentProvider
import com.afghazy.framework.mvvm.ui.feed.opensource.OpenSourceFragmentProvider
import com.afghazy.framework.mvvm.ui.login.LoginActivity
import com.afghazy.framework.mvvm.ui.login.LoginActivityModule
import com.afghazy.framework.mvvm.ui.splash.SplashActivity
import com.afghazy.framework.mvvm.ui.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FeedActivityModule::class,
        BlogFragmentProvider::class,
        OpenSourceFragmentProvider::class])
    internal abstract fun bindFeedActivity(): FeedActivity

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun bindLoginActivity(): LoginActivity
}