package com.maxjspaulding.whistle.issuebrowser

import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.maxjspaulding.whistle.issuebrowser.api.IssuesApi
import com.maxjspaulding.whistle.issuebrowser.api.data.Comment
import com.maxjspaulding.whistle.issuebrowser.api.data.Issue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class CommentController @Inject constructor(private val issuesApi: IssuesApi) : EpoxyController(){

    private var issue: Issue? = null
    private val comments = mutableListOf<Comment>()

    private var index = 0L

    override fun buildModels(): Unit {

        issue?.let { safeIssue ->
            IssueHeaderModel_(safeIssue)
                .id(index++)
                .addTo(this)

            comments.forEach { comment ->
                CommentModel_(comment)
                    .id(index++)
                    .addTo(this)
            }
        }
    }

    fun loadComments(issue: Issue) {
        this.issue = issue

        GlobalScope.launch(Dispatchers.Default) {
            val request = issuesApi.loadIssueComments(RXJAVA_OWNER, RXJAVA_REPO, issue.number)
            try {
                val response = request.await()
                comments.clear()
                comments.addAll(0, response)
                requestModelBuild()
            } catch (e: HttpException) {
                Log.e("CommentController", "loadComments() failed due to an HTTP error code=${e.code()}", e)
            } catch (e: Throwable) {
                Log.e("CommentController", "loadComments() failed due to an exception.  msg='${e.message}'", e)
            }
        }
    }


}

