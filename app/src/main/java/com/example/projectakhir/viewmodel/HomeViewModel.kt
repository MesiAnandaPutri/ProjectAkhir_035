package com.example.projectakhir.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.modeldata.DataProduk
import com.example.projectakhir.repositori.RepositoriDataProduk
import kotlinx.coroutines.launch
import java.io.IOException

data class HomeUIState(
    val listProduk: List<DataProduk> = listOf()
)

class HomeViewModel(private val repositoriDataProduk: RepositoriDataProduk) : ViewModel() {

    var homeUIState by mutableStateOf(HomeUIState())
        private set

    init {
        getProduk()
    }

    fun getProduk() {
        viewModelScope.launch {
            try {
                // PERBAIKAN: repositori.getProduk() sekarang langsung mengembalikan List<DataProduk>
                homeUIState = homeUIState.copy(listProduk = repositoriDataProduk.getProduk())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
