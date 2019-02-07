package com.maxjspaulding.whistle.issuebrowser

import android.app.Activity
import com.maxjspaulding.whistle.issuebrowser.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

class IssuesApplication : DaggerApplication(), HasActivityInjector {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return super.activityInjector()
    }

}