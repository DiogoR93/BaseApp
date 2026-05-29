package com.dffr.baseapp.data.repository

import com.dffr.baseapp.data.model.toDomain
import com.dffr.baseapp.data.remote.ApiService
import com.dffr.baseapp.domain.model.Card
import com.dffr.baseapp.domain.repository.CardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : CardRepository {

    override suspend fun getCards(): Result<List<Card>> = runCatching {
        apiService.getCards().map { it.toDomain() }
    }
}
