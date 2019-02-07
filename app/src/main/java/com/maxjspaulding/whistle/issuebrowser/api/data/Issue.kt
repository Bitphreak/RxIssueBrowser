package com.maxjspaulding.whistle.issuebrowser.api.data

data class Issue(
    val id: Long,        // NOTE: I didn't see the scope of id in the github api docs so I used a Long for safety's sake. id might fit in an Int
    val node_id: String,
    val url: String,
    val repository_url: String,
    val labels_url: String,
    val comments_url: String,
    val events_url: String,
    val html_url: String,
    val number: Long,
    val state: String,
    val title: String,
    val body: String,
    val user: User,
    val assignee: User,
    val assignees: List<User>,
    val labels: List<Label>,
    val milestone: Milestone,
    val locked: Boolean,
    val active_lock_reason: String,
    val comments: Int,
    val pull_request: PullRequest?,
    val closed_at: String?,
    val created_at: String,
    val updated_at: String
)