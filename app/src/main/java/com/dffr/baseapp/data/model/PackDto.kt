package com.dffr.baseapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PackDto(
    val id: Long,
    val name: String,
    val colorHex: String,
)
