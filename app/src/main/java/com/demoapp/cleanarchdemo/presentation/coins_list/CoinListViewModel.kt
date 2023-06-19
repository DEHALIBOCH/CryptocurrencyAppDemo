package com.demoapp.cleanarchdemo.presentation.coins_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demoapp.cleanarchdemo.common.Resource
import com.demoapp.cleanarchdemo.domain.use_cases.get_coins.GetCoinsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsListUseCase: GetCoinsListUseCase
) : ViewModel() {

    private val _state = mutableStateOf<CoinsListState>(CoinsListState())
    val state: State<CoinsListState> = _state

    init {
        getAllCoins()
    }

    private fun getAllCoins() {
        getCoinsListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinsListState(coins = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CoinsListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}