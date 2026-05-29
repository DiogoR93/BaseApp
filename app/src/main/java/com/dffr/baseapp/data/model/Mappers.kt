package com.dffr.baseapp.data.model

import com.dffr.baseapp.domain.model.Card
import com.dffr.baseapp.domain.model.Pack

fun CardDto.toDomain() = Card(id = id, description = description, packId = packId)
fun PackDto.toDomain() = Pack(id = id, name = name, colorHex = colorHex)
