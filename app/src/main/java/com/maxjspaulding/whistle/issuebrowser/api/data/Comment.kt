package com.maxjspaulding.whistle.issuebrowser.api.data

data class Comment(
    val id: Long,
    val node_id: String,
    val url: String,
    val html_url: String,
    val body: String,
    val user: User,
    val created_at: String,
    val updated_at: String
)