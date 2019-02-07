package com.maxjspaulding.whistle.issuebrowser

import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.maxjspaulding.whistle.issuebrowser.api.IssuesApi
import com.maxjspaulding.whistle.issuebrowser.api.data.Issue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class IssueController(private val issuesApi: IssuesApi) : EpoxyController(){

    private val issues = mutableListOf<Issue>()

    private var index = 0L

    override fun buildModels() = issues.forEach{
        IssueModel_(it)
            .id(index++)
            .addTo(this)
    }

    fun loadIssues() {

        GlobalScope.launch(Dispatchers.Default) {
            val request = issuesApi.listIssues("ReactiveX", "RxJava")
            try {
                val response = request.await()
                issues.clear()
                issues.addAll(0, response)
                requestModelBuild()
            } catch (e: HttpException) {
                Log.e("IssueController", "loadIssues() failed due to an HTTP error code=${e.code()}", e)
            } catch (e: Throwable) {
                Log.e("IssueController", "loadIssues() failed due to an exception.  msg='${e.message}'", e)
            }
        }
    }


}