package com.maxjspaulding.whistle.issuebrowser.di

import com.maxjspaulding.whistle.issuebrowser.CommentController
import com.maxjspaulding.whistle.issuebrowser.IssueController
import com.maxjspaulding.whistle.issuebrowser.api.IssuesApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Suppress("unused")
object EpoxyModule {

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideIssueController(issuesApi: IssuesApi): IssueController {
        return IssueController(issuesApi)
    }

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideCommentController(issuesApi: IssuesApi): CommentController {
        return CommentController(issuesApi)
    }
}