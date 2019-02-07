package com.maxjspaulding.whistle.issuebrowser

import android.app.Activity
import android.app.Fragment
import com.maxjspaulding.whistle.issuebrowser.di.DaggerAppComponent
import dagger.android.*

class IssuesApplication : DaggerApplication(), HasActivityInjector, HasFragmentInjector {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return super.activityInjector()
    }

    override fun fragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return super.fragmentInjector()
    }
}