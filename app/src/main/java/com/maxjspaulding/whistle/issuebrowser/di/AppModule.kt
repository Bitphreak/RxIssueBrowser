package com.maxjspaulding.whistle.issuebrowser.di

import android.content.Context
import com.maxjspaulding.whistle.issuebrowser.IssuesApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: IssuesApplication): Context = application.applicationContext

}