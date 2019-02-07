package com.maxjspaulding.whistle.issuebrowser.api.data

data class Label(
    val id: Long,
    val node_id: String,
    val url: String,
    val name: String,
    val description: String,
    val color: String,
    val default: Boolean
)
