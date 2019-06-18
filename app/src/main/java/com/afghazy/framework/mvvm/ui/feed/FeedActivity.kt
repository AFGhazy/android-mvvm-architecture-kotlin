package com.afghazy.framework.mvvm.ui.feed

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.afghazy.framework.mvvm.BR
import com.afghazy.framework.mvvm.R
import com.afghazy.framework.mvvm.databinding.ActivityFeedBinding
import com.afghazy.framework.mvvm.utils.ViewModelProviderFactory
import com.afghazy.framework.mvvm.ui.base.BaseActivity
import com.afghazy.framework.mvvm.ui.base.BaseViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

class FeedActivity : BaseActivity<ActivityFeedBinding, Any, FeedViewModel>(), HasSupportFragmentInjector {
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    internal lateinit var factory: ViewModelProviderFactory

    override val viewModel: FeedViewModel
        get() = ViewModelProviders.of(this, factory).get(FeedViewModel::class.java)

    override val layoutId: Int
        get() = R.layout.activity_feed

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

}