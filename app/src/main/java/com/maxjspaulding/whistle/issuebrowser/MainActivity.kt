package com.maxjspaulding.whistle.issuebrowser

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.maxjspaulding.whistle.issuebrowser.api.data.Issue
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(), IssueControllerCallback {

    private val fragmentManager: FragmentManager = supportFragmentManager

    @Inject lateinit var issueListFragment: IssueListFragment
    @Inject lateinit var commentListFragment: CommentListFragment
    @Inject lateinit var issueController: IssueController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        issueController.callback = this
        showIssueList()
    }

    override fun onPause() {
        super.onPause()
        issueController.callback = null
    }

    fun displayFragment(fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(fragment.toString())
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }

    fun showIssueList(){
        displayFragment(issueListFragment)
    }

    override fun showIssueComments(issue: Issue) {
        commentListFragment.issue = issue
        displayFragment(commentListFragment)
    }

}
