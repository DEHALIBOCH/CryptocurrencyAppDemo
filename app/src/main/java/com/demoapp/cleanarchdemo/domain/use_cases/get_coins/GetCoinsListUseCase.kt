package com.demoapp.cleanarchdemo.domain.use_cases.get_coins

import com.demoapp.cleanarchdemo.common.Resource
import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.toCoin
import com.demoapp.cleanarchdemo.domain.models.Coin
import com.demoapp.cleanarchdemo.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsListUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getAllCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server"))
        }
    }
}