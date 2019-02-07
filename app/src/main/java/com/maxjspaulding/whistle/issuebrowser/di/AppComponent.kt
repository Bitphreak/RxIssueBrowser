package com.maxjspaulding.whistle.issuebrowser.di

import com.maxjspaulding.whistle.issuebrowser.IssuesApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<IssuesApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<IssuesApplication>()
}