package com.maxjspaulding.whistle.issuebrowser

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyController
import com.maxjspaulding.whistle.issuebrowser.api.IssuesApi
import com.maxjspaulding.whistle.issuebrowser.api.data.Issue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject


const val RXJAVA_REPO = "RxJava"
const val RXJAVA_OWNER = "ReactiveX"

interface IssueControllerCallback {
    fun showIssueComments(issue: Issue)
}

class IssueController @Inject constructor(private val issuesApi: IssuesApi) : EpoxyController(){

    private val issues = mutableListOf<Issue>()

    private var index = 0L

    var callback: IssueControllerCallback? = null

    override fun buildModels() = issues.forEach { issue ->
        IssueModel_(issue)
            .id(index++)
            .clickListener {
                Log.d("IssueController", "Issue clicked:${issue.number}")
                callback?.showIssueComments(issue)
            }
            .addTo(this)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        loadIssues()
    }

    fun loadIssues() {

        GlobalScope.launch(Dispatchers.Default) {
            val request = issuesApi.loadIssues("ReactiveX", "RxJava")
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

