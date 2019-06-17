package com.afghazy.framework.mvvm.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.afghazy.framework.mvvm.BuildConfig
import com.afghazy.framework.mvvm.data.local.db.AppDatabase
import com.afghazy.framework.mvvm.data.local.prefs.AppPrefHelper
import com.afghazy.framework.mvvm.data.local.prefs.PrefHelper
import com.afghazy.framework.mvvm.data.manager.AppDataManager
import com.afghazy.framework.mvvm.data.manager.DataManager
import com.afghazy.framework.mvvm.data.remote.ApiHelper
import com.afghazy.framework.mvvm.data.remote.AppApiHelper
import com.afghazy.framework.mvvm.data.remote.header.ProtectedApiHeader
import com.afghazy.framework.mvvm.di.qualifier.ApiInfo
import com.afghazy.framework.mvvm.di.qualifier.DatabaseInfo
import com.afghazy.framework.mvvm.di.qualifier.PrefsInfo
import com.afghazy.framework.mvvm.utils.DB_NAME
import com.afghazy.framework.mvvm.utils.PREF_NAME
import com.afghazy.framework.mvvm.utils.rx.AppSchedulerProvider
import com.afghazy.framework.mvvm.utils.rx.SchedulerProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @ApiInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @Singleton
    internal fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @DatabaseInfo
    internal fun provideDatabaseName(): String {
        return DB_NAME
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    @Provides
    @PrefsInfo
    internal fun providePreferenceName(): String {
        return PREF_NAME
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPrefHelper: AppPrefHelper): PrefHelper =  appPrefHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(
        @ApiInfo apiKey: String,
        preferencesHelper: PrefHelper
    ): ProtectedApiHeader {
        return ProtectedApiHeader(
            apiKey,
            preferencesHelper.accessToken,
            preferencesHelper.currentUserId
        )
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    internal fun provideSharedPreferences(context: Context, @PrefsInfo prefFileName: String): SharedPreferences =
            context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
}