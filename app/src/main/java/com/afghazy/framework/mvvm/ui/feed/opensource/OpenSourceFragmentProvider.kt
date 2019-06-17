package com.afghazy.framework.mvvm.ui.feed.opensource

import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Module
abstract class OpenSourceFragmentProvider {

    @ContributesAndroidInjector(modules = [OpenSourceFragmentModule::class])
    abstract fun bindOpenSourceFragment(): OpenSourceFragment
}