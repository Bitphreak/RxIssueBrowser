package com.maxjspaulding.whistle.issuebrowser

import android.os.Bundle
import com.maxjspaulding.whistle.issuebrowser.api.IssuesApi
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var issuesApi: IssuesApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
