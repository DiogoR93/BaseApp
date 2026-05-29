package com.dffr.baseapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CardDto(
    val id: Long,
    val description: String,
    val packId: Long,
)
