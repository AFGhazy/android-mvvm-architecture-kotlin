package com.afghazy.framework.mvvm.ui.feed

import dagger.Module
import dagger.Provides


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Module
class FeedActivityModule {

    @Provides
    internal fun provideFeedPagerAdapter(activity: FeedActivity): FeedPagerAdapter {
        return FeedPagerAdapter(activity.supportFragmentManager)
    }

}
