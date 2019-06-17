package com.afghazy.framework.mvvm.ui.feed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.afghazy.framework.mvvm.ui.feed.blogs.BlogFragment
import com.afghazy.framework.mvvm.ui.feed.opensource.OpenSourceFragment


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

class FeedPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var mTabCount: Int = 0

    init {
        this.mTabCount = 0
    }

    override fun getCount(): Int {
        return mTabCount
    }

    fun setCount(count: Int) {
        mTabCount = count
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return BlogFragment.newInstance()
            1 -> return OpenSourceFragment.newInstance()
            else -> return null
        }
    }
}