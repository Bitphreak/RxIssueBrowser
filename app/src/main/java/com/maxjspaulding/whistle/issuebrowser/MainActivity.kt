package com.maxjspaulding.whistle.issuebrowser

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maxjspaulding.whistle.issuebrowser.api.IssuesApi
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotterknife.bindView
import retrofit2.HttpException
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private val issuesList: RecyclerView by bindView(R.id.rv_issues_list)

    @Inject
    lateinit var issueController : IssueController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    private fun initRecycler(){
        val linearLayoutManager = LinearLayoutManager(this)
        issuesList.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = issueController.adapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, linearLayoutManager.orientation))
        }

        //This statement builds model and add it to the recycler view
        issueController.loadIssues()
    }
}
