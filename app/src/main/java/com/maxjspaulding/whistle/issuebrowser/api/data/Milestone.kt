package com.maxjspaulding.whistle.issuebrowser.api.data

data class Milestone(
    val id: Long,
    val url: String,
    val html_url: String,
    val labels_url: String,
    val node_id: String,
    val number: Int,
    val state: String,
    val title: String,
    val description: String,
    val creator: User,
    val open_issues: Int,
    val closed_issues: Int,
    val created_at: String,
    val updated_at: String,
    val closed_at: String,
    val due_on: String
)
