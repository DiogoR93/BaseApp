package com.dffr.baseapp.domain.repository

import com.dffr.baseapp.domain.model.Card

interface CardRepository {
    suspend fun getCards(): Result<List<Card>>
}
