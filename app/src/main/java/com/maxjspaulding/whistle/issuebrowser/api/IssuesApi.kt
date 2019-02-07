package com.maxjspaulding.whistle.issuebrowser.api

import com.maxjspaulding.whistle.issuebrowser.api.data.Issue
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

// API Reference https://developer.github.com/v3/issues/
interface IssuesApi {

    @GET("/repos/{owner}/{repo}/issues")
    fun listIssues(@Path("owner") owner: String, @Path("repo") repo: String): Deferred<List<Issue>>

}