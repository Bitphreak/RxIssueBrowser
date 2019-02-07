package com.maxjspaulding.whistle.issuebrowser.api.data

data class PullRequest(
    val url: String,
    val html_url: String,
    val diff_url: String,
    val patch_url: String
)

