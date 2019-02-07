package com.maxjspaulding.whistle.issuebrowser.di

import com.maxjspaulding.whistle.issuebrowser.IssueListFragment
import com.maxjspaulding.whistle.issuebrowser.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
@Suppress("unused")
internal abstract class ActivityModule {

    @ContributesAndroidInjector()
    internal abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributesIssueListFragment(): IssueListFragment
}