package com.maxjspaulding.whistle.issuebrowser.di

import com.maxjspaulding.whistle.issuebrowser.IssueController
import com.maxjspaulding.whistle.issuebrowser.api.IssuesApi
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
@Suppress("unused")
object EpoxyModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideIssueController(issuesApi: IssuesApi): IssueController {
        return IssueController(issuesApi)
    }
}