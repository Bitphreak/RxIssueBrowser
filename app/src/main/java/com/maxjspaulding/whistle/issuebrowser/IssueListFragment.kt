package com.maxjspaulding.whistle.issuebrowser

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class IssueListFragment @Inject constructor(): DaggerFragment() {


    private lateinit var issuesList: RecyclerView

    @Inject
    lateinit var issueController : IssueController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_issue_list, container, false)
        initRecycler(view)
        return view
    }

    override fun onAttach(activity: Activity?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(activity)

    }

    private fun initRecycler(view: View) {
        issuesList = view.findViewById(R.id.rv_issues_list)
        val linearLayoutManager = LinearLayoutManager(context)
        issuesList.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = issueController.adapter
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
        }

        //This statement builds model and add it to the recycler view
        issueController.loadIssues()
    }
}
