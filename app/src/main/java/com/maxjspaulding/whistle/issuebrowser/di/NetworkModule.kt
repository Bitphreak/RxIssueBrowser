package com.maxjspaulding.whistle.issuebrowser.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.maxjspaulding.whistle.issuebrowser.api.IssuesApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@Suppress("unused")
object NetworkModule {


    @Provides
    @Reusable
    @JvmStatic
    internal fun provideIssuesApi(retrofit: Retrofit): IssuesApi {
        return retrofit.create(IssuesApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

}